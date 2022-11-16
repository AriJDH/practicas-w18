package com.example.multicapa.repository;

import com.example.multicapa.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository{

    List<Persona> personas = new ArrayList<>();

    public PersonaRepositoryImp(){
        cargarPersonas();
    }

    @Override
    public List<Persona> finAll() {
        return personas;
    }

    private void cargarPersonas(){
        personas.add(new Persona("Laura", "Gutiérrez", 29));
        personas.add(new Persona("Henry", "Gutiérrez", 26));
        personas.add(new Persona("Jhon", "Betancourt", 32));
        personas.add(new Persona("Stephania", "Betancourt", 26));

    }
}
