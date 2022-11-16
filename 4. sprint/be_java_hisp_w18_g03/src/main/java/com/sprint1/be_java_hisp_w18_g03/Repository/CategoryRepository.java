package com.sprint1.be_java_hisp_w18_g03.Repository;

import com.sprint1.be_java_hisp_w18_g03.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
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
        return null;
    }
}
