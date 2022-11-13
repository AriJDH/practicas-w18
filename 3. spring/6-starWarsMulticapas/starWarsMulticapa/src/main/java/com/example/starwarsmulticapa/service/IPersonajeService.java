package com.example.starwarsmulticapa.service;

import com.example.starwarsmulticapa.dto.request.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> searchByName(String name);
}
