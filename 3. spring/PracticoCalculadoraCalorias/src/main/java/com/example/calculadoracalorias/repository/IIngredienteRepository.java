package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    List<Ingrediente> loadList();
}
