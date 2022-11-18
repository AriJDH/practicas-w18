package com.sprint1.be_java_hisp_w18_g03_serna.Repository;

import com.sprint1.be_java_hisp_w18_g03_serna.entity.Category;

public interface ICategoryRepository {
    Category findCategoryById(Integer idCategory);
}
