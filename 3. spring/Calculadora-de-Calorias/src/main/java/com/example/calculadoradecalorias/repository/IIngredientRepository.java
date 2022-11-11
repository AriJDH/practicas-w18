package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> findAll();
}
