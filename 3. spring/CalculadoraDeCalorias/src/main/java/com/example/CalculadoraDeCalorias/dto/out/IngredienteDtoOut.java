package com.example.CalculadoraDeCalorias.dto.out;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDtoOut {
    String nombre;
    Integer calorias;
}
