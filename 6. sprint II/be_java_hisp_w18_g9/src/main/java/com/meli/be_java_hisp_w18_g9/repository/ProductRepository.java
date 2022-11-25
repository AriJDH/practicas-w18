package com.meli.be_java_hisp_w18_g9.repository;

import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    // ? ==================== Attributes ==================== ?

    private static final List<Product> products = new ArrayList<>();

    // ? ==================== Methods ==================== ?

    /**
     * Get all products
     * @return List<Product>
     */
    @Override
    public List<Product> findAll() {
        return products;
    }

    // * ===============

    /**
     * Get product by Id
     * @param id product to search
     * @return Product
     */
    @Override
    public Product findById(Integer id) {
        return products.stream().filter(product -> product.getProductId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException(String.format("Product with id %d not found", id)));
    }

    // * ===============

    /**
     * save a product
     * @param entity product to save
     */
    @Override
    public Product save(Product entity) {
        products.add(entity);
        return entity;
    }

    // * ===============

    /**
     * update a product
     * @param entity fields to update products
     * @param id Product to update
     */
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

    // * ===============

    /**
     * delete a product
     * @param id product to delete
     */
    @Override
    public void deleteById(Integer id) {
        Product productObtained = findById(id);
        products.remove(productObtained);
    }

}
