package com.example.starwars.service;

import com.example.starwars.dto.response.PersonajeResponseDto;

import java.util.ArrayList;
import java.util.List;

public interface IPersonajeService {
    List<PersonajeResponseDto> mostrarPersonajesPorNombre(String name);
}
