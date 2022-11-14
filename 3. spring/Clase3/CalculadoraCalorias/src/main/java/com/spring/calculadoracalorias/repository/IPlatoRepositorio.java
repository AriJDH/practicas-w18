package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Plato;

public interface IPlatoRepositorio {
    Plato obtenerPlato(String nombre);
}
