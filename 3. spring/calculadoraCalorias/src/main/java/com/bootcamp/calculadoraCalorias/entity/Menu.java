package com.bootcamp.calculadoraCalorias.entity;

import com.bootcamp.calculadoraCalorias.entity.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {

    private List<Dish> dishes;
}
