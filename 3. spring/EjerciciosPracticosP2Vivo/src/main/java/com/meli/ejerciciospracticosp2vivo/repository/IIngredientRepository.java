package com.meli.ejerciciospracticosp2vivo.repository;

import com.meli.ejerciciospracticosp2vivo.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    List<Ingredient> getIngredientAll();
}
