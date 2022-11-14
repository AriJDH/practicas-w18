package com.example.calculadordecalorias.dto.resp;

import com.example.Calorias.entity.Ingredient;
import com.example.calculadordecalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class DishDTO {
    private Integer calories;
    private List<Ingredient> ingredients;
    private Ingredient ingredientMaxCalories;
}