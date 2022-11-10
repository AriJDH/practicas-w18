package com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.repository;

import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model.Persona;
import com.ejerciciospring.ejercicios_spring.practica_p2_pg_response.model.Sintoma;
import com.ejerciciospring.ejercicios_spring.repository.IRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonaRepository implements IRepository<Persona> {

    private List<Persona> personas;

    public PersonaRepository() {

        List<Sintoma> sintomas = List.of(new Sintoma("1", "Gripa", 3));

        Persona persona = new Persona(1L, "Dizzi", "Tren", 70, sintomas);

        this.personas = List.of(persona);

    }

    @Override
    public void crear(Persona entidad) {
        //no se implementa
    }

    @Override
    public List<Persona> consultarEntidades() {
        return personas;
    }

    @Override
    public Persona consultarEntidadPorNombre(String nombre) {
        //no se implementa
        return null;
    }
}
