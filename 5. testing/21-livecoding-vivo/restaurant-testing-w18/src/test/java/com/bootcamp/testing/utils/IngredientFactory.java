package com.bootcamp.testing.utils;

import com.bootcamp.testing.model.Ingredient;

public class IngredientFactory {
    public static Ingredient getIngredientWithQuality(Integer ingredientQuality) {
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("ingredient1");
        ingredient1.setQuality(ingredientQuality);
        ingredient1.setQuantity(0);
        ingredient1.setCalories(0);
        return ingredient1;
    }
}
