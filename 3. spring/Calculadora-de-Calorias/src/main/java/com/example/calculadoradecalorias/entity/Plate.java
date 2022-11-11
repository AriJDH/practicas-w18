package com.example.calculadoradecalorias.entity;

import com.example.calculadoradecalorias.dto.IngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plate {

    private String name;
    private double totalWeight;
    private List<IngredientDto> ingridients;
    private IngredientDto ingridientWithTheMostCalories;
}
