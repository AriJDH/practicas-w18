package com.example.edad_persona.repository;

import com.example.edad_persona.domain.Deporte;
import com.example.edad_persona.domain.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository{

    private List<Persona> personas = new ArrayList<>();

    @Override
    public List<Persona> findAll() {
        return personas;
    }

    @Override
    public void crear(Persona persona){
        personas.add(persona);
    }


}
