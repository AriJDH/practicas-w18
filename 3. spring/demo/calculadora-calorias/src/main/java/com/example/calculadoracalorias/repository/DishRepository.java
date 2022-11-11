package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository{

    private final List<Dish> dishes = new ArrayList<Dish>();

    @Override
    public List<Dish> getDishes() {
        return null;
    }

    @Override
    public Dish getDish(String name) {
        return null;
    }

    @Override
    public Dish addDish(DishDTOreq dish) {
        return null;
    }

    @Override
    public Integer getDishCaloriesByName(String name) {
        return null;
    }

    @Override
    public Integer getDishWithMostCaloriesByName(String name) {
        return null;
    }
}
