package com.example.demo.service;

import com.example.demo.dto.response.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> getPersonaje(String name);
}
