package com.example.edad_persona.repository;

import com.example.edad_persona.domain.Deporte;

import java.util.List;
import java.util.Optional;

public interface DeporteRepository {

    List<Deporte> findAll();
    Optional<Deporte> findByNombre(String nombre);
}
