package com.example.spring.dtoYResponseEntity.deporte.repository;

import com.example.spring.dtoYResponseEntity.deporte.entity.Deporte;
import com.example.spring.dtoYResponseEntity.deporte.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public abstract class RepoPersonas {
    private static ArrayList<Persona> personas = new ArrayList<Persona>();

    static {
        personas.add(new Persona("Tana", "Cing", 39, new ArrayList<Deporte>()));
        personas.add(new Persona("Nico", "Rodriguez", 18, new ArrayList<Deporte>()));
        personas.add(new Persona("Fede", "Paz", 18, new ArrayList<Deporte>()));
        personas.add(new Persona("Joaquina", "Ramirez", 18, new ArrayList<Deporte>()));
    }
}
