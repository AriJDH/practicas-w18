package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository implements  IProductRepository {
    @Override
    public Product addProduct(Product product) {
        Product product1 = new Product(product.getProductId(), product.getProductName(), product.getType(), product.getBrand(), product.getColor(), product.getNotes());
        return product1;
    }
}
