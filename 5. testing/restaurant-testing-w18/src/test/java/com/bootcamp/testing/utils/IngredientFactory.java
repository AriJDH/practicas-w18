package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Ingredient;

public class IngredientFactory
{
    public static Ingredient getIngredientWithQuality(String name, Integer quality)
    {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setQuality(quality);
        ingredient.setQuantity(1);
        ingredient.setCalories(1);
        return ingredient;
    }
}
