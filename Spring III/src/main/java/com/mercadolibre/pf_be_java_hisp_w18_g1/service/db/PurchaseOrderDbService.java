package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.PurchaseOrder;

public interface PurchaseOrderDbService {
    PurchaseOrder findByOrderNumber(Long order);
    void delete(PurchaseOrder purchaseOrder);
    PurchaseOrder save(PurchaseOrder purchaseOrder);
}
