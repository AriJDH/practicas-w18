package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.dto.require.DishToPostDTOreq;
import com.example.calculadoracalorias.dto.response.DishDTOres;
import com.example.calculadoracalorias.entity.Ingredient;

import java.util.List;

public interface IDishService {
    Integer getDishCaloriesByName(String name);
    DishDTOres getDishByName(String name);
    DishDTOres getDish(DishDTOreq dishDTO);
    Ingredient getDishWithMostCaloriesByName(String name);
    List<DishDTOres> findDishes(List<DishDTOreq> dishesDTOreq);

    void addDish(DishToPostDTOreq dish);

}
