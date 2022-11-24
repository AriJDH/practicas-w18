package com.jcundere.ejerciciopractico07.service;

import com.jcundere.ejerciciopractico07.dto.response.FoodMealResponse;

import java.util.List;

public interface IFoodService {

    FoodMealResponse calculateCaloriesTotal(List<String> foodMeals);

}
