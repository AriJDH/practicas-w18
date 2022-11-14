package com.example.calculadordecalorias.service;

iimport com.example.Calorias.dto.response.DishDTO;
import com.example.Calorias.entity.Dish;
import com.example.calculadordecalorias.dto.resp.DishDTO;

public interface IDishService {
    DishDTO findDishByName(String name);
}

