package com.example.CalculadoraDeIngredientes.dto;

import com.example.CalculadoraDeIngredientes.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlatoDto {
    private String name;
    private List<Ingrediente> ingredients;
}
