package com.example.frescos.service.db;

import com.example.frescos.entity.Product;

public interface ProductDbService {
    public Product findById(Long id);
}
