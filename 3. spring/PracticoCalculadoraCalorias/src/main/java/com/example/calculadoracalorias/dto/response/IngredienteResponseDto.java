package com.example.calculadoracalorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredienteResponseDto {
    private String nombre;
    private Integer calorias;
}
