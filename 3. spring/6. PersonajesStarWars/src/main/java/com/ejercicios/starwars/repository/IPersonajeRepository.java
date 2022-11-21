package com.kotor.starwars.repository;

import com.kotor.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
    List<Personaje> findByName(String name);
}
