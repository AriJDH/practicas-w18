package com.example.calorias.DTOs;

import com.example.calorias.entities.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombre;
    private List<IngredienteDTO> ingredientes;
    private double calorias;
    private IngredienteDTO ingredienteMasCalorico;
}
