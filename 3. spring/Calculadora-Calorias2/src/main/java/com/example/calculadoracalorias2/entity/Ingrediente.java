package com.example.calculadoracalorias2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingrediente {
    private String name;
    private double calories;
}
