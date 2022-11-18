package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajesService {
    List<PersonajeDTO> getAll();

    List<PersonajeDTO> getByName(String name);
}
