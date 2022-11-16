package com.example.demodeportistas.repository;

import com.example.demodeportistas.entity.Deporte;
import com.example.demodeportistas.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    public List<Persona> personas;
    public DeporteRepository deporteRepo;

    public PersonaRepository() {
        this.personas = new ArrayList<>();
        this.deporteRepo = new DeporteRepository();

        personas.add(new Persona("Gabriel", "Guerra", 38, deporteRepo.deportes.get(0)));
        personas.add(new Persona("Gabriela", "Ortega", 40, deporteRepo.deportes.get(1)));
        personas.add(new Persona("Laura", "Gutiérrez", 29, deporteRepo.deportes.get(2)));
    }
}
