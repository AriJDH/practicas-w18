package com.restaurante.restaurante.repository;

import com.restaurante.restaurante.entity.Ingrediente;
import com.restaurante.restaurante.entity.Plato;

import java.util.List;

public interface ImenuRepository {
    public List<Plato> getAll();
}
