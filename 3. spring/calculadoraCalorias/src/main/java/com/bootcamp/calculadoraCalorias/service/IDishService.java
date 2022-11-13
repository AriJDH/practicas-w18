package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.res.DishDto;
import com.bootcamp.calculadoraCalorias.dto.req.DishReqDto;
import com.bootcamp.calculadoraCalorias.entity.Dish;
import com.bootcamp.calculadoraCalorias.entity.Ingredient;

import java.util.List;

public interface IDishService {

    DishDto getData(DishReqDto dishDto);
    Double sumCalories(Dish dish);
    List<Ingredient> findIngredientAndCalories(Dish dish);
    Double maxCalories(Dish dish);
    Dish findByName(String name);
}
