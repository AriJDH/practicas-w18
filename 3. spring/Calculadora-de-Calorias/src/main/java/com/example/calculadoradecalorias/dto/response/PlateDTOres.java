package com.example.calculadoradecalorias.dto.response;

import com.example.calculadoradecalorias.dto.IngredientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlateDTOres {

    private String name;
    private double totalWeight;
    private List<IngredientDto> ingridients;
    private IngredientDto ingridientWithTheMostCalories;
}
