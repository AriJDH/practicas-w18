package com.example.frescos.utils;

import com.example.frescos.dtos.BatchDTO;
import com.example.frescos.dtos.BatchStockDTO;
import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.dtos.SectionDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.entity.InboundOrder;
import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.service.db.ProductDbService;
import com.example.frescos.service.db.WarehouseDbService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Mapper {
    @Autowired
    private WarehouseDbService warehouseDbService;
    @Autowired
    private ProductDbService productDbService;
    private ModelMapper modelMapper = new ModelMapper();
    public InboundOrder fromDTO(InboundOrderDTO inboundOrderDTO){
        InboundOrder inboundOrder = modelMapper.map(inboundOrderDTO, InboundOrder.class);
        inboundOrder.setSection(this.fromDTO(inboundOrderDTO.getSection()));
        inboundOrder.setBatches(inboundOrderDTO.getBatches().stream()
                .map(batchDTO -> this.fromDTO(batchDTO)).collect(Collectors.toList()));
        return inboundOrder;
    }

    public Section fromDTO(SectionDTO sectionDTO){
        Warehouse warehouse = warehouseDbService.findByWarehouseCode(sectionDTO.getWarehouseCode());
        return warehouse.getSectionFromCode(sectionDTO.getSectionCode());
    }

    public Batch fromDTO(BatchDTO batchDTO){
        Batch batch = modelMapper.map(batchDTO, Batch.class);
        batch.setProduct(productDbService.findById(batchDTO.getProductId()));
        return batch;
    }

    public BatchStockDTO fromBatch(Batch batch){
        BatchStockDTO batchStockDTO = modelMapper.map(batch, BatchStockDTO.class);
        return batchStockDTO;
    }
}
