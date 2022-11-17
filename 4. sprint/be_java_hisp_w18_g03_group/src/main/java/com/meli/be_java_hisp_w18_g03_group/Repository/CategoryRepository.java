package com.meli.be_java_hisp_w18_g03_group.Repository;

import com.meli.be_java_hisp_w18_g03_group.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository {
    private List<Category> categoryList = new ArrayList<>();

    public CategoryRepository() {
        categoryList.add(new Category(100, "Casa"));
        categoryList.add(new Category(1, "Habitacion"));
        categoryList.add(new Category(199, "Sala"));
        categoryList.add(new Category(99, "Cocina"));
    }

    @Override
    public Category findCategoryById(Integer idCategory) {
        return categoryList.stream().filter(c -> c.getCategoryId().equals(idCategory)).findFirst().orElse(null);
    }
}
