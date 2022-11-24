package com.bootcamp.testing.dto.request;

import com.bootcamp.testing.dto.IngredientRecipeDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {
    private String                    name;
    private String                    description;
    private List<IngredientRecipeDTO> ingredients;
}
