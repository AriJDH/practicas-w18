package com.waow.calories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plate {
    private String name;
    private Map<Ingredient, Integer> ingredientGramsMap;

    public int getBasePlateGrams() {
        int plateGrams = 0;
        for (Map.Entry<Ingredient, Integer> ingredientGramsEntry : getIngredientGramsMap().entrySet()) {
            plateGrams += ingredientGramsEntry.getValue();
        }
        return plateGrams;
    }
}
