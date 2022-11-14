package com.ejerciciospring.ejercicios_spring.calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Plato {

    private String nombre;

    private List<Food> foods;

    private Integer pesoGramo;
}
