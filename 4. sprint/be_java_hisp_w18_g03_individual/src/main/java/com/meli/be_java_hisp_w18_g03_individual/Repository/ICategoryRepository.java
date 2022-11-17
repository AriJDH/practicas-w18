package com.meli.be_java_hisp_w18_g03_individual.Repository;

import com.meli.be_java_hisp_w18_g03_individual.entity.Category;

public interface ICategoryRepository {
    Category findCategoryById(Integer idCategory);
}
