package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajes(String query);
}
