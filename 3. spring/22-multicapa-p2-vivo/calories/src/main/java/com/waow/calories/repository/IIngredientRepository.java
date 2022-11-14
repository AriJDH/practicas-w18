package com.waow.calories.repository;

import com.waow.calories.entity.Ingredient;

import java.util.Optional;


public interface IIngredientRepository {
    Optional<Ingredient> findIngredient(String name);
}
