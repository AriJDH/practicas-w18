package com.example.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private String name;
    private List<Ingredient> ingredients;
    private Double weight;

}
