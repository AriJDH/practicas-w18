package com.jcundere.ejerciciopractico07.repository;

import com.jcundere.ejerciciopractico07.entity.Food;

import java.util.List;

public interface IFoodRepository {

    List<Food> getAll();
    Food save(Food food);
    Food getByName(String name);
    Food update(String name, Food update);
    void deleteByName(String name);

}
