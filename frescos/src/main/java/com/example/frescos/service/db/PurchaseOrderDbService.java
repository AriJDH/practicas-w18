package com.example.frescos.service.db;

import com.example.frescos.entity.PurchaseOrder;

public interface PurchaseOrderDbService {
    PurchaseOrder findByOrderNumber(Long order);
}
