package com.bootcamp.starwars.repository;

import com.bootcamp.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> findByName(String name);
}
