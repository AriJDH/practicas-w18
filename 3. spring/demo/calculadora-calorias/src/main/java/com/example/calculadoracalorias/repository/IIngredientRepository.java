package com.example.calculadoracalorias.repository;


import com.example.calculadoracalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> getIngredients();
    Ingredient getIngredient(String name);


}
