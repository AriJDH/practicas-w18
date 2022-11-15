package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Plato;

import java.util.List;

public interface IRepositoryPlatos {
    void add(Plato plato);
    List<Plato> listAll();
    Plato findByName(String name);
}
