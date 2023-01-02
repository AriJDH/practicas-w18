package com.example.frescos.service.db;

import com.example.frescos.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderDbService {
    PurchaseOrder findByOrderNumber(Long order);
    void delete(PurchaseOrder purchaseOrder);
    PurchaseOrder save(PurchaseOrder purchaseOrder);
    List<PurchaseOrder> findAllByBuyerId(Long buyerId);
    List<PurchaseOrder> findAllByBuyerUsername(String userName);
}
