package com.spring.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlatoDtoRes {
    private int calories;
    private List<IngredienteDtoRes> ingredientes;
    private IngredienteDtoRes masCalorico;
}
