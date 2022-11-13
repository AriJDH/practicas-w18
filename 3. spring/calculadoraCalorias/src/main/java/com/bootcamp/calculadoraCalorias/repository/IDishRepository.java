package com.bootcamp.calculadoraCalorias.repository;

import com.bootcamp.calculadoraCalorias.entity.Dish;

import java.util.List;

public interface IDishRepository {

    void create();
    List<Dish> findAll();
}
