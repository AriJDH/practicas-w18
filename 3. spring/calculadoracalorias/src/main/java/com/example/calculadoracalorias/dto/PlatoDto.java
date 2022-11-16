package com.example.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlatoDto {

    private Integer cantidadTotalCalorias;
    private List<FoodDto> ingredientes;
    private String ingredienteMasCaloria;
    private String message;
}
