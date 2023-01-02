package com.mercadolibre.pf_be_java_hisp_w18_g1.util;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.*;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.*;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.SectionRepository;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.BuyerDbService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.ProductDbService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.WarehouseDbService;
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
    @Autowired
    private SectionRepository sectionRepository;

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
        return sectionRepository.findById( warehouse.getSectionFromCode(sectionDTO.getSectionCode()).getId()).get();
    }

    public Batch fromDTO(BatchDTO batchDTO){
        Batch batch = modelMapper.map(batchDTO, Batch.class);
        batch.setProduct(productDbService.findById(batchDTO.getProductId()));
        return batch;
    }

    public BatchForStockDTO toDTO(Batch batch){
        BatchForStockDTO batchStockDTO = modelMapper.map(batch, BatchForStockDTO.class);
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
