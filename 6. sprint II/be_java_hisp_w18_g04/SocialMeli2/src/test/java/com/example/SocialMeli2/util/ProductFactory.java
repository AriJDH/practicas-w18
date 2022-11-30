package com.example.SocialMeli2.util;

import com.example.SocialMeli2.entity.Product;

public class ProductFactory {
    public static Product getProduct(){
        Product product = new Product();
        product.setProduct_id(3);
        product.setProduct_name("Product 3");
        product.setType("Type 3");
        product.setBrand("Brand 3");
        product.setColor("Color 3");
        product.setNotes("Notes 3");
        return product;
    }

    public static Product getProduct9(){
        Product product = new Product();
        product.setProduct_id(9);
        product.setProduct_name("Product 9");
        product.setType("Type 9");
        product.setBrand("Brand 9");
        product.setColor("Color 9");
        product.setNotes("Notes 9");
        return product;
    }

    public static Product getProduct10(){
        Product product = new Product();
        product.setProduct_id(10);
        product.setProduct_name("Product 10");
        product.setType("Type 10");
        product.setBrand("Brand 10");
        product.setColor("Color 10");
        product.setNotes("Notes 10");
        return product;
    }

}
