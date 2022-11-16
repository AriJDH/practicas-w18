package com.example.starwars.repository;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> findAll();
}
