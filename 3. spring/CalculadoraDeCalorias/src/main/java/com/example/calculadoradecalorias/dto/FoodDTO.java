package com.ejerciciospring.ejercicios_spring.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FoodDTO {

    private String name;

    private Integer calories;
}
