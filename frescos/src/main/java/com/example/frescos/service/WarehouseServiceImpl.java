package com.example.frescos.service;

import com.example.frescos.dtos.SectionDTO;
import com.example.frescos.dtos.WarehouseDTO;
import com.example.frescos.entity.Product;
import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.service.db.ProductDbService;
import com.example.frescos.service.db.SectionDbServiceImpl;
import com.example.frescos.service.db.WarehouseDbService;
import com.example.frescos.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
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
    public List<WarehouseDTO> findByProduct(Long id, Character order) {
        Product product = productDbService.findById(id);
        Section section = sectionDbService.findBySectionCode(product.getSectionCode());

        List<Warehouse> warehouses = warehouseDbService.findAllBySection(section.getSectionCode());
        SectionDTO sectionDTO = new SectionDTO();

        List<WarehouseDTO> warehousesResponse = warehouses.stream()
                .map(w -> {
                    sectionDTO.setSectionCode(section.getSectionCode().getCode());
                    sectionDTO.setWarehouseCode(w.getWareHouseCode());
                    return getSectionWarehouse(w.getSections(), section);})
                .map(s -> s.getBatches())
                .map(b -> b.stream().filter(p -> p.getProduct().getId().equals(id)))
                .map(b ->
                        warehouseOrderBatches(new WarehouseDTO(sectionDTO, product.getId(),
                                b.map(p -> mapper.fromBatch(p))
                                .collect(Collectors.toList())), order))
                .collect(Collectors.toList());

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

    private Section getSectionWarehouse(List<Section> sections, Section section){
        return sections.stream().filter(s -> s.getSectionCode().equals(section.getSectionCode())).findFirst().orElse(null);
    }
}
