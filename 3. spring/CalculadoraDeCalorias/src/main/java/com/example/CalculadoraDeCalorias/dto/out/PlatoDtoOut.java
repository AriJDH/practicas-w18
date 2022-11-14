package com.example.CalculadoraDeCalorias.dto.out;


import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDtoOut {

    private List<IngredienteDtoOut> ingredientes;
    private Integer totalCalorias;
    private IngredienteDtoOut ingredienteMasCalorico;

}
