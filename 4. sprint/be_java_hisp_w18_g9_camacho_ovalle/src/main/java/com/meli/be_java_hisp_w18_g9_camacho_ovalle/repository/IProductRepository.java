package com.meli.be_java_hisp_w18_g9_camacho_ovalle.repository;

import com.meli.be_java_hisp_w18_g9_camacho_ovalle.model.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    Product save(Product entity);
    Product update(Integer id, Product entity);
    void deleteById(Integer id);
}
