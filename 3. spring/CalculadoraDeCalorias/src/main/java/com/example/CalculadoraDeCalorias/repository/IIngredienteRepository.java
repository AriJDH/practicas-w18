package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;

import java.util.List;


public interface IIngredienteRepository {
    List<Ingrediente> findAll();

    Ingrediente findByName(String name);
}
