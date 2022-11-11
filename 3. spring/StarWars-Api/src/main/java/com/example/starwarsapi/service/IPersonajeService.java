package com.example.starwarsapi.service;

import com.example.starwarsapi.dto.request.PersonajeDto;
import com.example.starwarsapi.entity.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> findAll();
}
