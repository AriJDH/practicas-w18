package com.mercadolibre.cuentacalorias.repository;

import com.mercadolibre.cuentacalorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {

    List<Plato> getAll();
    Plato getByName(String name);
    Plato create(Plato plato);

}
