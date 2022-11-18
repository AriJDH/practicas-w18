package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajesRepository {
    List<Personaje> findAll();
    List<Personaje> findByName(String name);

}
