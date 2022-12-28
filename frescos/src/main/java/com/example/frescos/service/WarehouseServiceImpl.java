package com.example.frescos.service;

import com.example.frescos.dtos.ProductWarehouseDTO;
import com.example.frescos.dtos.SectionDTO;
import com.example.frescos.dtos.WarehouseDTO;
import com.example.frescos.dtos.WarehouseQuantityDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.entity.Product;
import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.service.db.ProductDbService;
import com.example.frescos.service.db.WarehouseDbService;
import com.example.frescos.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
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

    private WarehouseDTO warehouseOrderBatches(WarehouseDTO warehouseDTO, Character order){
        if (order == null)
            return warehouseDTO;

        switch (order){
            case 'L', 'l':
                Collections.sort(warehouseDTO.getBatches(), (x, y) -> x.getBatchNumber().compareTo(y.getBatchNumber()));
                break;
            case 'C', 'c':
                Collections.sort(warehouseDTO.getBatches(), (x, y) -> x.getCurrentQuantity().compareTo(y.getCurrentQuantity()));
                break;
            case 'F', 'f':
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
