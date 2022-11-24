package com.example.calculadordecalorias.repository;


import com.example.Calorias.entity.Dish;
import com.example.calculadordecalorias.entity.Dish;

public interface IDishRepository {
    Dish findDishByName(String name);
}

