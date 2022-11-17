package com.meli.ejerciciospracticosp2vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String name;
    private List<IngredientDishDTO> ingredientList;
}
