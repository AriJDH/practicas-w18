package com.example.calculadordecalorias.service;

import com.example.Calorias.dto.response.DishDTO;
import com.example.Calorias.entity.Dish;
import com.example.Calorias.repository.DishRepositoryImp;
import com.example.Calorias.repository.IDishRepository;
import com.example.calculadordecalorias.dto.resp.DishDTO;
import com.example.calculadordecalorias.entity.Dish;
import com.example.calculadordecalorias.repository.DishRepositoryImp;
import com.example.calculadordecalorias.repository.IDishRepository;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImp implements IDishService{
    private IDishRepository dishRepository;

    public DishServiceImp(DishRepositoryImp dishRepositoryImp) {
        this.dishRepository = dishRepositoryImp;
    }

    @Override
    public DishDTO findDishByName(String name) {
        Dish dish = dishRepository.findDishByName(name);
        return new DishDTO(dish.calculateCalories(),dish.getIngredients(),dish.calculateIngredientMaxCalories());

    }
}