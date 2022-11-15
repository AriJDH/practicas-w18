package com.apicalorias.CalculadoraCalorias.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class IngredienteDTO {
    private String name;
    private Integer calories;

    @Override
    public String toString() {
        return '\n'+ "Nombre=" + name + '\n' +
                "Calorias=" + calories+ '\n';
    }
}
