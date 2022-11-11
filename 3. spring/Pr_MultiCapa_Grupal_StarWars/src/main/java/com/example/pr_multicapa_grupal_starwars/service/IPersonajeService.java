package com.example.pr_multicapa_grupal_starwars.service;

import com.example.pr_multicapa_grupal_starwars.dto.PersonajeDto;
import com.example.pr_multicapa_grupal_starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> findByName(String name);
    List<PersonajeDto> findAll();
}
