package com.example.edad_persona.service;

import com.example.edad_persona.dto.PersonaDto;

import java.util.List;

public interface PersonaService {

    List<PersonaDto> findAll();
}
