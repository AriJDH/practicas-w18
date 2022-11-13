package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {


    List<Ingredient> getIngredients();

}
