package com.example.spring.multicapa.starwars.repository;

import com.example.spring.multicapa.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
    List<Personaje> findByName(String name);
}
