package com.example.calculadoracalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IngredienteResponseDTO {
    private String name;
    private Integer calories;
}
