package com.mercadolibre.pf_be_java_hisp_w18_g1.service;


import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();
    List<ProductDTO> findByCategory(String category);
}
