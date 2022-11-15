package com.apistarwars.StarWarsPersonajes.service;

import com.apistarwars.StarWarsPersonajes.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajesService {
    public List<PersonajeDTO> retornarListaPersonajes(String nombre);
}
