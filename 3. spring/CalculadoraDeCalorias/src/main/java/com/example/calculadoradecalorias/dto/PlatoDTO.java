package com.ejerciciospring.ejercicios_spring.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoDTO {

    private Integer cantidadTotalCalorias;

    private List<FoodDTO> ingredientes;

    private String ingredienteMasCaloria;

    private String message;
}
