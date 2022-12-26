package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;

import java.util.List;

public interface PurchaseOrderService {
    List<ProductDTO> findProductsByOrder(Long order);
}
