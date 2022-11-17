package com.meli.be_java_hisp_w18_g03_group.Repository;

import com.meli.be_java_hisp_w18_g03_group.entity.Category;

public interface ICategoryRepository {
    Category findCategoryById(Integer idCategory);
}
