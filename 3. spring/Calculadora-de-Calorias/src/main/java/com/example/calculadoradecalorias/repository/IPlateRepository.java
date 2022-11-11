package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingredient;
import com.example.calculadoradecalorias.entity.Plate;

import java.util.List;

public interface IPlateRepository {
    List<Plate> findAll();
    List<Ingredient> showIngredients(String name, Double weight);
}
