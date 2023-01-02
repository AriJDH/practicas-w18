package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();
    List<ProductDTO> findByCategory(String category);
}
