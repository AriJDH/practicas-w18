package com.apicalorias.CalculadoraCalorias.repository;

import com.apicalorias.CalculadoraCalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredientesRepository {
    public List<Ingrediente> retornarListaIngredientes();

}
