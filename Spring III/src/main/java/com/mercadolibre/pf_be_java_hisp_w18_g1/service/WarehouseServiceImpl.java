package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.*;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Batch;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Product;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Warehouse;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.BadRequestException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.ProductDbService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.WarehouseDbService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

@Service
@Transactional
public class WarehouseServiceImpl implements WarehouseService{
    @Autowired
    private WarehouseDbService warehouseDbService;
    @Autowired
    private ProductDbService productDbService;
    @Autowired
    private Mapper mapper;

    @Override
    public List<WarehouseDTO> findByProductForSection(Authentication authentication, Long id, Character order) {
        Product product = productDbService.findById(id);
        List<Warehouse> warehouses = warehouseDbService.findAllWarehouseBySectionsAndAgent(product.getSectionCode(), authentication.getName());

        List<WarehouseDTO> warehousesResponse = warehouses.stream()
                .map(w -> getWarehouse(w, product, order))
                .collect(Collectors.toList());

        List<WarehouseDTO> filtro = warehousesResponse.stream().filter(w -> w.getBatches().size()>0).collect(Collectors.toList());
        if (filtro.isEmpty())
            throw new EntityNotFoundException("No existe un warehouse con ese producto y esa sección.");
        return warehousesResponse;
    }

    @Override
    public ProductWarehouseDTO findByProduct(Authentication authentication, Long id){
        Product product = productDbService.findById(id);
        List<Warehouse> warehouses = warehouseDbService.findAllWarehouseBySectionsAndAgent(product.getSectionCode(), authentication.getName());
        List<WarehouseQuantityDTO> warehouseQuantity = warehouses.stream()
                .map(w -> {
                    Integer quantity = w.getSections().stream()
                            .filter(s -> s.getSectionCode().equals(product.getSectionCode())).findFirst()
                            .map(s -> s.getBatches())
                            .map(b -> b.stream()
                                    .filter(bp -> bp.getProduct().getId().equals(id))
                                    .map(p -> p.getCurrentQuantity())
                                    .reduce(0, Integer::sum))
                            .get();

                    return new WarehouseQuantityDTO(w.getWareHouseCode(), quantity);}

                ).collect(Collectors.toList());

        ProductWarehouseDTO productResponse = new ProductWarehouseDTO(id, warehouseQuantity);

        List<WarehouseQuantityDTO> filtro = productResponse.getWarehouses().stream().filter(w -> w.getTotalQuantity()>0).collect(Collectors.toList());
        if (filtro.isEmpty())
            throw new EntityNotFoundException("No existe un warehouse con ese producto y esa sección.");

        return productResponse;
    }

    @Override
    public List<SectionBatchesDTO> findAllProductForSectionInWarehouse(Authentication authentication, Long warehouseCode, Integer minimumStock) {
        if(minimumStock <= 0)
            throw new BadRequestException("El valor del stock mínimo a buscar debe ser mayor a cero.");


        //Busco el warehouse
        Warehouse warehouse = warehouseDbService.findWarehouseByWareHouseCodeAndAgent_UserName(warehouseCode, authentication.getName());

        //Creo la respuesta
        List<SectionBatchesDTO> response = warehouse.getSections().stream()
                .map(s -> {
                    //Creo lista de todos los productos por cada sección, filtrando la fecha de vencimiento.
                    List<ProductStockDTO> products = s.getBatches().stream()
                            .filter(b -> validationBatchByProductAndDueDate(b, b.getProduct().getId()))
                            .map(b -> {
                                return new ProductStockDTO(b.getProduct().getId(), b.getCurrentQuantity());
                            })
                            .collect(Collectors.toList());

                    //Ordeno la lista para poder sumar sus cantidades
                    Collections.sort(products, (x, y) -> x.getProductId().compareTo(y.getProductId()));

                    //Elimino productos repetidos y sumo sus cantidades
                    for (int i = 0; i < products.size()-1; i++) {
                        if (products.get(i+1).getProductId().equals(products.get(i).getProductId())){
                            products.get(i).setCurrentQuantity(products.get(i).getCurrentQuantity()+products.get(i+1).getCurrentQuantity());
                            products.remove(i+1);
                            i -= 1;
                        }
                    }

                    //Filtro por cada sección los productos que cumplen con el mínimo de stock.
                    List<ProductStockDTO> productsStock = products.stream().filter(p -> p.getCurrentQuantity() < minimumStock).collect(Collectors.toList());

                    //Valido si la lista de productos está vacía
                    if (productsStock.isEmpty())
                        return null;

                    //Creo la respuesta
                    SectionBatchesDTO section = new SectionBatchesDTO(s.getSectionCode(), productsStock);

                    return  section;})
                .collect(Collectors.toList());

        //Elimino secciones vacias
        response = response.stream().filter(s -> s != null).collect(Collectors.toList());

        //Valido el contenido de la respuesta
        if (response.isEmpty())
            throw new EntityNotFoundException("No existe un producto con una cantidad menor a " + minimumStock + " en stock.");

        return response;
    }

    private WarehouseDTO warehouseOrderBatches(WarehouseDTO warehouseDTO, Character order){
        if (order == null)
            return warehouseDTO;

        switch (order){
            case 'L':
            case 'l':
                Collections.sort(warehouseDTO.getBatches(), (x, y) -> x.getBatchNumber().compareTo(y.getBatchNumber()));
                break;
            case 'C':
            case 'c':
                Collections.sort(warehouseDTO.getBatches(), (x, y) -> x.getCurrentQuantity().compareTo(y.getCurrentQuantity()));
                break;
            case 'F':
            case 'f':
                Collections.sort(warehouseDTO.getBatches(), (x, y) -> x.getDueDate().compareTo(y.getDueDate()));
                break;
            default:
                throw new BadRequestException("Parámetro erróneo. Por favor intente nuevamente.");
        }
        return warehouseDTO;
    }

    private Boolean validationBatchByProductAndDueDate(Batch batch, Long id){
        long weeksBetween = ChronoUnit.WEEKS.between(LocalDate.now(), batch.getDueDate());
        if (batch.getProduct().getId().equals(id) && weeksBetween>= 3)
            return true;
        else
            return false;
    }
    private WarehouseDTO getWarehouse(Warehouse warehouse, Product product, Character order){
        List<Section> sections = warehouse.getSections();

        WarehouseDTO warehouseDTO = sections.stream()
                .filter(s -> s.getSectionCode().equals(product.getSectionCode())).findFirst()
                .map(s -> s.getBatches())
                .map(b -> b.stream().filter(p -> validationBatchByProductAndDueDate(p, product.getId())))
                .map(b -> warehouseOrderBatches(new WarehouseDTO(new SectionDTO(product.getSectionCode().getCode(), warehouse.getWareHouseCode()), product.getId(),
                        b.map(p -> mapper.toDTO(p))
                                .collect(Collectors.toList())), order))
                .get();
        return warehouseDTO;
    }
}
