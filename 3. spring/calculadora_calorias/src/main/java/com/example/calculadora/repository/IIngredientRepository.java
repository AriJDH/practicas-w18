package com.example.calculadora.repository;

import com.example.calculadora.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {

    List<Ingredient> getIngredients();
}
