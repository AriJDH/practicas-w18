package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonajeDTO> getChars(String busqueda);
}
