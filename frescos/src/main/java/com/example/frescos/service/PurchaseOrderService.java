package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.PurchaseOrderDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;

import java.util.List;

public interface PurchaseOrderService {
    List<ProductDTO> findProductsByOrder(Long order);
    void addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest);
}
