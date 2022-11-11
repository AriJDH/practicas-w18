package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.entity.Dish;

import java.util.List;

public interface IDishRepository {

    List<Dish> getDishes();
    Dish getDish(String name);
    Dish addDish(Dish dish);
    Integer getDishCaloriesByName(String name);
    Integer getDishWithMostCaloriesByName(String name);


}
