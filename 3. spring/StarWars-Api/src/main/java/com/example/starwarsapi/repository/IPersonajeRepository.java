package com.example.starwarsapi.repository;

import com.example.starwarsapi.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
       List<Personaje> findAll();
       Personaje findOne(String nombre);
}
