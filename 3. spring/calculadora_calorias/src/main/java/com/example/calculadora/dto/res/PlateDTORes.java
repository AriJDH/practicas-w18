package com.example.calculadora.dto.res;

import com.example.calculadora.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlateDTORes {

    private Double calories;
    private List<Ingredient> ingredients;
    private Double maxCalorieIngredient;
}
