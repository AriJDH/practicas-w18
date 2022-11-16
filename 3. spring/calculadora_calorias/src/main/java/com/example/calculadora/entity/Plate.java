package com.example.calculadora.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Plate {

    private String name;
    private List<Ingredient> ingredients=new ArrayList<>();
}
