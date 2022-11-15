package com.example.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Plato {
    private String name;
    private List<Ingrediente> ingredienteList;
}
