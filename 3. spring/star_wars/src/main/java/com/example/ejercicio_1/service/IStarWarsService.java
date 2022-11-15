package com.example.ejercicio_1.service;

import com.example.ejercicio_1.dto.PersonajeDTO;

import java.util.List;

public interface IStarWarsService {

    List<PersonajeDTO> findByName(String name);
}
