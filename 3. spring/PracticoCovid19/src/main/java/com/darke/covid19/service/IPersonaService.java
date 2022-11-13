package com.darke.covid19.service;

import com.darke.covid19.dto.request.PersonaRequestDto;
import com.darke.covid19.dto.response.PersonaResponseDto;

import java.util.List;

public interface IPersonaService {
    void crearPersona(PersonaRequestDto personaRequestDto);
    List<PersonaResponseDto> buscarPersonaRiesgo();
}
