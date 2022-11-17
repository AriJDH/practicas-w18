package com.dh.be_java_hisp_w18_g10.repository;

import com.dh.be_java_hisp_w18_g10.entity.Product;

import java.util.List;

public interface IProductRepository {
    Product getProductById(int id);
    List<Product> getProducts();
    void addProduct(Product product);
}
