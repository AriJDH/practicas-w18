package com.meli.ejerciciospracticosp2vivo.repository;

import com.meli.ejerciciospracticosp2vivo.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepositoryImp implements IFoodRepository{

    List<Food> foodList = new ArrayList<>();

    @Override
    public List<Food> getFoodAll() {
        return foodList;
    }
}
