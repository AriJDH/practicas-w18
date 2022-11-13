package com.bootcamp.calculadoraCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingredient {

    private String name;
    private Double calories;

}
