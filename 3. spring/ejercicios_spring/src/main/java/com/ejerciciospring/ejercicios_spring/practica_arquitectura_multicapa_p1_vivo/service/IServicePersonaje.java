package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.service;

import com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.dto.PersonajeDTO;

import java.util.List;

public interface IServicePersonaje {

    List<PersonajeDTO> consultarPersonajesPorNombre(String nombre);
}
