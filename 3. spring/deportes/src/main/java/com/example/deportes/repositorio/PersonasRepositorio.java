package com.example.deportes.repositorio;

import com.example.deportes.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonasRepositorio {
    List<Persona> personas = new ArrayList<>();

    public void setPersonas(Persona persona){
        personas.add(persona);
    }
}
