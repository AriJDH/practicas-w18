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
}
