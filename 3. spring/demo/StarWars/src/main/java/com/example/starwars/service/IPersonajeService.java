package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getPersonajeByName(String name);
}
