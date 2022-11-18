package com.sprint1.be_java_hisp_w18_g03.repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Category;

public interface ICategoryRepository {
    Category findCategoryById(Integer idCategory);
}
