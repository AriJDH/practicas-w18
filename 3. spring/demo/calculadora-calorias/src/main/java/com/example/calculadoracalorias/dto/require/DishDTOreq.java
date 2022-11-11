package com.example.calculadoracalorias.dto.require;

import com.example.calculadoracalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DishDTOreq {

    private String name;
    private List<String> ingredientsName;
    private Double weight;

}
