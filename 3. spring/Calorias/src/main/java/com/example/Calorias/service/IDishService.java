package com.example.Calorias.service;

import com.example.Calorias.dto.response.DishDTO;
import com.example.Calorias.entity.Dish;

public interface IDishService {
    DishDTO findDishByName(String name);
}
