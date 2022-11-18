package com.example.spring.multicapa.starwars.service;

import com.example.spring.multicapa.starwars.dto.PersonajeDTOResponse;
import com.example.spring.multicapa.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTOResponse> getAll();
    List<PersonajeDTOResponse> findByName(String name);
}
