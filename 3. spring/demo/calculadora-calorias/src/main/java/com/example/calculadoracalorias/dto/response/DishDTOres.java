package com.example.calculadoracalorias.dto.response;

import com.example.calculadoracalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DishDTOres {

    private Integer totalCalories;
    private List<Ingredient> ingredients;
    private Integer ingredientsWithMostCalories;

}
