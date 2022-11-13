package com.darke.covid19.repository;

import com.darke.covid19.dto.request.PersonaRequestDto;
import com.darke.covid19.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public interface IPersonaRepository {
    void agregarPersona(PersonaRequestDto personaRequestDto);
    List<Persona> getPersonas();
}
