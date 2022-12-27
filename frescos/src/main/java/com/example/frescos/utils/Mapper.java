package com.example.frescos.utils;

import com.example.frescos.dtos.*;
import com.example.frescos.entity.*;
import com.example.frescos.service.db.BuyerDbService;
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
    @Autowired
    private BuyerDbService buyerDbService;
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

    public BatchStockDTO toDTO(Batch batch){
        BatchStockDTO batchStockDTO = modelMapper.map(batch, BatchStockDTO.class);
        return batchStockDTO;
    }

    public PurchaseOrder fromDTO(PurchaseOrderDTO purchaseOrderDTO){
        PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);
        purchaseOrder.setBuyer(buyerDbService.findById(purchaseOrderDTO.getBuyerId()));
        purchaseOrder.setStatus(purchaseOrderDTO.getOrderStatus().getStatusCode());
        purchaseOrder.setItems(purchaseOrderDTO.getItems().stream()
                .map(itemDTO -> this.fromDTO(itemDTO)).collect(Collectors.toList()));
        return purchaseOrder;
    }

    public Item fromDTO(ItemDTO itemDTO){
        Item item = new Item();
        item.setQuantity(itemDTO.getQuantity());
        item.setProduct(productDbService.findById(itemDTO.getProductId()));
        return item;
    }
}
