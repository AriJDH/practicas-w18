package com.bootcamp.calculadoraCalorias.dto.res;

import com.bootcamp.calculadoraCalorias.entity.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DishDto {

    private Double calories;
    private List<Ingredient>ingredients;
    private Double maxCalorieIngredient;
}
