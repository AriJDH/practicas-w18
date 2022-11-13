package com.bootcamp.calculadoraCalorias.service;

import com.bootcamp.calculadoraCalorias.dto.res.DishDto;
import com.bootcamp.calculadoraCalorias.dto.req.DishReqDto;
import com.bootcamp.calculadoraCalorias.entity.Dish;
import com.bootcamp.calculadoraCalorias.entity.Ingredient;
import com.bootcamp.calculadoraCalorias.repository.IDishRepository;
import com.bootcamp.calculadoraCalorias.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishService implements IDishService {


    @Autowired
    private IDishRepository dishRepository;

    @Override
    public DishDto getData(DishReqDto dishDto) {
        DishDto dto=new DishDto();
        Dish dish=findByName(dishDto.getName());
        dto.setCalories(sumCalories(dish)*(dishDto.getGr()/1000));
        dto.setIngredients(findIngredientAndCalories(dish));
        dto.setMaxCalorieIngredient(maxCalories(dish));
        return dto;
    }

    @Override
    public Double sumCalories(Dish dish) {

        return dish.getIngredients().stream().mapToDouble(i->i.getCalories()).sum();
    }

    @Override
    public List<Ingredient> findIngredientAndCalories(Dish dish) {
        return dish.getIngredients();
    }

    @Override
    public Double maxCalories(Dish dish) {
        return dish.getIngredients().stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .get().getCalories();
    }


    @Override
    public Dish findByName(String name) {
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst()
                .get();
    }





}
