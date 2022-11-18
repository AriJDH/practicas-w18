package com.mercadolibre.cuentacalorias.repository;

import com.mercadolibre.cuentacalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {

    List<Ingrediente> getAll();
    Ingrediente findByName(String name);


}
