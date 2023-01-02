package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.PurchaseOrderDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;
import com.example.frescos.dtos.response.PurchaseOrderCreationResponseDTO;

import java.util.List;

public interface PurchaseOrderService {
    List<ProductDTO> findProductsByOrder(Long order);

    PurchaseOrderCreationResponseDTO addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest);
    PurchaseOrderCreationResponseDTO updatePurchaseOrder(Long orderId, PurchaseOrderRequest purchaseOrderRequest);
}
