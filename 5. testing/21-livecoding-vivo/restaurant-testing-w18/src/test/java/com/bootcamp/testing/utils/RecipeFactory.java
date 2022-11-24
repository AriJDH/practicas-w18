package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Ingredient;
import com.bootcamp.testing.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeFactory {
    public static Recipe getRecipeWithQuality(String dishName) {
        Recipe recipe = new Recipe();
        recipe.setName(dishName);
        recipe.setDescription("lorem ipsum");
        recipe.setIngredients(new ArrayList<>());
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(IngredientFactory.getIngredientWithQuality(4));
        ingredientList.add(IngredientFactory.getIngredientWithQuality(3));
        recipe.setIngredients(ingredientList);
        return recipe;
    }
}
