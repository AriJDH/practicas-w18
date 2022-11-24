package com.bootcamp.testing.service;

import com.bootcamp.testing.dto.request.RecipeDTO;
import com.bootcamp.testing.dto.response.DishResponseDTO;
import com.bootcamp.testing.model.Recipe;

import java.util.List;

public interface IKitchenService {

    /* Kitchen */
    DishResponseDTO createDish( String name);

    /* Recipe */
    List<RecipeDTO> getRecipes();
    Recipe getRecipe( String name);
    RecipeDTO createRecipe(RecipeDTO recipe);
}
