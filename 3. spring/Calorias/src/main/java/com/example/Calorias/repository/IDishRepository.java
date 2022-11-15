package com.example.Calorias.repository;

import com.example.Calorias.entity.Dish;

public interface IDishRepository {
    Dish findDishByName(String name);
}
