package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.dto.response.DishDTOres;

public interface IDishService {
    Integer getDishCaloriesByName(String name);
    DishDTOres getDishByName(String name);
    Integer getDishMostCaloriesByName(String name);

    void addDish(DishDTOreq dish);

}
