package com.apicalorias.CalculadoraCalorias.dto;

import java.util.List;
import java.util.Map;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PlatoConCantidadesDTO {
    private String nombre;
    private List<IngredientesConCantidadesDTO> ingredientes;
}