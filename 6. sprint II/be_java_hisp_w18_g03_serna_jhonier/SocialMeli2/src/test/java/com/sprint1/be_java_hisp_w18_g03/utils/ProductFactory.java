package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.Category;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;

public class ProductFactory {

    public static Product getProduct(){
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("productito");
        Category category = CategoryFactory.getCategory();
        product.setCategory(category);
        return product;
    }

    public static Product createProduct(){
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("productito");
        Category category = CategoryFactory.getCategory();
        product.setCategory(category);
        product.setBrand("marca");
        product.setColor("verde");
        product.setNotes("notas del producto");
        product.setType("tipo");
        product.setPrice(45567.5);
        return product;
    }
}
