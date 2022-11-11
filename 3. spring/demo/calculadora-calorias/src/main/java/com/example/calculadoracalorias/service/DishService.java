package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.require.DishDTOreq;
import com.example.calculadoracalorias.dto.response.DishDTOres;
import com.example.calculadoracalorias.entity.Dish;
import com.example.calculadoracalorias.repository.DishRepository;
import com.example.calculadoracalorias.repository.IDishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService implements IDishService{

    private final IDishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Integer getDishCaloriesByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public DishDTOres getDishByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public Integer getDishMostCaloriesByName(String name) {
        //TO-DO: implement
        return null;
    }

    @Override
    public void addDish(DishDTOreq dishDTO) {
        Dish dishToAdd = new Dish();
        dishRepository.addDish(dishToAdd);
    }
}
