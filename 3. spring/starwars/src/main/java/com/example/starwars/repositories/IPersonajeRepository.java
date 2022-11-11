package com.example.starwars.repositories;

import com.example.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {

    List<Personaje> findAll();
    void loadList();
}
