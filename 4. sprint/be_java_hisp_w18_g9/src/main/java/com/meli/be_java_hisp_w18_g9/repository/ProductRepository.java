package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements  IEntityRepository<Product> {

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product entity) {
        Product product1 = new Product(entity.getProductId(), entity.getProductName(), entity.getType(), entity.getBrand(), entity.getColor(), entity.getNotes());
        return product1;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Integer update(Product entity) {
        return null;
    }
}
