package com.example.frescos.service;

import com.example.frescos.dtos.SectionDTO;
import com.example.frescos.dtos.WarehouseDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.entity.Product;
import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.service.db.ProductDbService;
import com.example.frescos.service.db.SectionDbServiceImpl;
import com.example.frescos.service.db.WarehouseDbService;
import com.example.frescos.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl implements WarehouseService{
    @Autowired
    private SectionDbServiceImpl sectionDbService;
    @Autowired
    private WarehouseDbService warehouseDbService;
    @Autowired
    private ProductDbService productDbService;
    @Autowired
    private Mapper mapper;

    @Override
    public WarehouseDTO findByProduct(Authentication authentication, Long id, Character order) {
        Product product = productDbService.findById(id);
        Section section = sectionDbService.findBySectionCode(product.getSectionCode());

        Warehouse warehouse = warehouseDbService.findWarehouseBySectionsAndAgent(section.getSectionCode(), authentication.getName());

        SectionDTO sectionDTO = new SectionDTO(section.getSectionCode().getCode(), warehouse.getWareHouseCode());

        WarehouseDTO warehousesResponse = warehouse.getSections().stream()
                .filter(s -> s.getSectionCode().equals(section.getSectionCode()))
                .map(s -> s.getBatches())
                .map(b -> b.stream().filter(p -> validationBatchByProductAndDueDate(p, product.getId())))
                .map(b ->
                        warehouseOrderBatches(new WarehouseDTO(sectionDTO, product.getId(),
                                b.map(p -> mapper.toDTO(p))
                                .collect(Collectors.toList())), order))
                .findFirst().get();

        return warehousesResponse;
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
}
