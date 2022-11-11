package com.example.pr_multicapa_grupal_starwars.repository;

import com.example.pr_multicapa_grupal_starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findByName(String name);
    List<Personaje> findAll();
}
