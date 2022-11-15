package com.example.ejercicio_1.repository;

import com.example.ejercicio_1.entity.Personaje;

import java.util.List;

public interface IStarWarsRepository {

    List<Personaje> findByName(String name);
}
