package com.sprint1.be_java_hisp_w18_g03.utils;

import com.sprint1.be_java_hisp_w18_g03.entity.Category;

public class CategoryFactory {
    public static Category getCategory(){
       Category category = new Category();
       category.setCategoryId(1);
       category.setName("alta categoria");
       return category;
    }

}
