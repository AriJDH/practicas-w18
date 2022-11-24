package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Recipe;

public class RecipeFactory
{
    public static Recipe getRecipe(String name)
    {
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription("aaaaaaaaaa");
        return recipe;
    }
}
