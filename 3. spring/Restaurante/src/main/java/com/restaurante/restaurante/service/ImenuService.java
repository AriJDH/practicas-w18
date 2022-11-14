package com.restaurante.restaurante.service;

import com.restaurante.restaurante.dto.PlatoDto;
import com.restaurante.restaurante.entity.Ingrediente;

import java.util.List;


public interface ImenuService {
    public Double getTotalCalorias(PlatoDto plato);

    public Ingrediente getMayorCaloria (PlatoDto plato);

    public List<Ingrediente> getAllIngredientes(PlatoDto plato);

}
