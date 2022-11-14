package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.require.DishToPostDTOreq;
import com.example.calculadoracalorias.entity.Dish;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DishRepository implements IDishRepository{
    private final List<Dish> dishes = new ArrayList<Dish>();

    @Override
    public void addDish(Dish dish) {
        dishes.add(dish);
    }
    @Override
    public Dish getDish(String name, Double weight) {
        for (Dish dish : dishes) {
            if (dish.getName().equals(name) && dish.getWeight().equals(weight)) {
                return dish;
            }
        }
        return null;
    }
    @Override
    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public List<Dish> getDishesByList(List<Dish> list) {
        return null;
    }
}
