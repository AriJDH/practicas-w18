package com.example.edad_persona.repository;

import com.example.edad_persona.domain.Deporte;
import com.example.edad_persona.domain.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PersonaRepository {

    List<Persona> findAll();
    void crear(Persona persona);
}
