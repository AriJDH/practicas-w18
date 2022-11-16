package com.example.covid.repositories;

import com.example.covid.domain.Persona;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaRepository extends ListRepository<Persona> {
    public List<Persona> findPersonasDeRiesgo(){
        return super.findAll().stream()
                .filter(persona -> persona.getSintomas().size()>0 && persona.getEdad()>60)
                .collect(Collectors.toList());
    }
}
