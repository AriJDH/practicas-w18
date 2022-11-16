package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Plato;

public interface IPlatoRepository {
    public Plato consultarPlato(String nombre, Integer peso);
}
