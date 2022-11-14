package com.example.CalculadoraDeCalorias.dto.in;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDtoIn {

    private String nombre;
    private Integer peso;

}
