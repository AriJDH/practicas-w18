package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Integer id);
    Product save(Product entity);
    Product update(Integer id, Product entity);
    void deleteById(Integer id);
}
