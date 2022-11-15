package com.example.calculadoracalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plato {
    private String nombre;
    private float peso;
    private List<Ingrediente> ingredientesList;
    private float totalCalorias;
}
