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

}
