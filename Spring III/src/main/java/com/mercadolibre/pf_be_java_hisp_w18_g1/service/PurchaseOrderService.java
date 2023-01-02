package com.mercadolibre.pf_be_java_hisp_w18_g1.service;


import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request.PurchaseOrderRequest;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response.PurchaseOrderCreationResponseDTO;

import java.util.List;

public interface PurchaseOrderService {
    List<ProductDTO> findProductsByOrder(Long order);

    PurchaseOrderCreationResponseDTO addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest);
    PurchaseOrderCreationResponseDTO updatePurchaseOrder(Long orderId,
                                                         PurchaseOrderRequest purchaseOrderRequest);
}
