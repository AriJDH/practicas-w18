package com.example.calculadoracalorias2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plato {
    private String name;
    private List<Ingrediente> ingredientes;
}
