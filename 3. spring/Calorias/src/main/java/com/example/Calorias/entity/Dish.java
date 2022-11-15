package com.example.Calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Data
public class Dish {
    String name;
    List<Ingredient> ingredients;

    public Dish() {
        this.ingredients = new ArrayList<>();
    }

    public Integer calculateCalories(){
        int calories=0;
        for(Ingredient ingredient: ingredients){
            calories+=ingredient.getCalories();
        }
        return calories;
    }

    public Ingredient calculateIngredientMaxCalories(){
        return ingredients.stream().max(Comparator.comparing(Ingredient::getCalories)).get();
    }
}
