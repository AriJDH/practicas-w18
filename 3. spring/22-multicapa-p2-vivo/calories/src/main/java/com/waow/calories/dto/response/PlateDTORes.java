package com.waow.calories.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlateDTORes {
    private Double caloriesTotal;
    private Map<String, Double> ingredientCaloriesMap;
    private String maxCalorieIngredient;
}
