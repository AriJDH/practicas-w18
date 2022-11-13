package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {

List<PersonajeDTO> getPersonajesByName(String name);

}
