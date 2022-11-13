package com.bootcamp.calculadoraCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    private String name;
    private List<Ingredient>ingredients=new ArrayList<>();


}
