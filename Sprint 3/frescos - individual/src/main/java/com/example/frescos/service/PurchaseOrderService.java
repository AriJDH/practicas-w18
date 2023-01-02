package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.PurchaseOrderDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;
import com.example.frescos.dtos.response.*;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface PurchaseOrderService {
    List<ProductDTO> findProductsByOrder(Long order);

    PurchaseOrderCreationResponseDTO addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest);
    PurchaseOrderCreationResponseDTO updatePurchaseOrder(Long orderId, PurchaseOrderRequest purchaseOrderRequest);
    PurchaseOrdersResponseDTO findAllPurchaseOrdersByBuyerId(Authentication authentication);
    TotalMoneySpentDTO purchaseOrdersTotal(Authentication authentication);
    ProductsResponseDTO findAllOrderedProducts(Authentication authentication);
    OrderedSectionsResponseDTO findAllOrderedSections(Authentication authentication);
    PurchaseOrderDTO findLastOrder(Authentication authentication);
}
