package com.example.CalculadoraDeCalorias.dto.in;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDtoIn {

    private List<IngredienteDtoIn> ingredienteList;

}
