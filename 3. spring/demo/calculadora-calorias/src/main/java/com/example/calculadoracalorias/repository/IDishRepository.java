package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Dish;

import java.util.List;

public interface IDishRepository {
    List<Dish> getDishes();
    List<Dish> getDishesByList(List<Dish> list);
    Dish getDish(String name, Double weight);
    void addDish(Dish dish);
}
