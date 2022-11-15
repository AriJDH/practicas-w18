package com.apicalorias.CalculadoraCalorias.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class IngredientesConCantidadesDTO {
    private String name;
    private Integer cantidad;
}
