package com.example.starwarsjson.services;

import com.example.starwarsjson.DTOs.PersonajeDTO;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDTO> findAllPersonajeDTO();
    List<PersonajeDTO> findAllPersonajeDTOByName(String name);

}
