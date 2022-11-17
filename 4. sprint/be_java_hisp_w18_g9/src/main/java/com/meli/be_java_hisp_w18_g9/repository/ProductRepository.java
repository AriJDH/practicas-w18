package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {

    // ? ==================== Attributes ==================== ?

    private static final List<Product> products = new ArrayList<>();

    // ? ==================== Methods ==================== ?


    @Override
    public List<Product> findAll() {
        return products;
    }

    // * ===============

    @Override
    public Product findById(Integer id) {
        return products.stream().filter(product -> product.getProductId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException(String.format("Product with id %d not found", id)));
    }

    // * ===============

    @Override
    public Product save(Product entity) {
        products.add(entity);
        return entity;
    }

    // * ===============

    @Override
    public Product update(Integer id, Product entity) {

        Product productObtained = findById(id);

        productObtained.setProductName(entity.getProductName());
        productObtained.setType(entity.getType());
        productObtained.setBrand(entity.getBrand());
        productObtained.setColor(entity.getColor());
        productObtained.setNotes(entity.getNotes());

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(id)) {
                products.set(i, productObtained);
            }
        }

        return productObtained;

    }

    @Override
    public void deleteById(Integer id) {
        Product productObtained = findById(id);
        products.remove(productObtained);
    }

}
