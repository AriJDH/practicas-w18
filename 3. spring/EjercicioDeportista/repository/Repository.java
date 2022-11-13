package com.mercadolibre.deportistas.repository;


import com.mercadolibre.deportistas.entity.Deporte;
import com.mercadolibre.deportistas.entity.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {
    List<Deporte> deportes = new ArrayList<>();
    List<Persona> personas = new ArrayList<>();

    public Repository() {
        this.cargarDatos();
    }

    private void cargarDatos() {
        Deporte basquet = new Deporte("Basquet", "Medio");
        Deporte waterpolo = new Deporte("Waterpolo", "Dificil");
        Deporte volley = new Deporte("Volley", "Medio");
        Deporte hockey = new Deporte("Hockey", "Dificil");
        Deporte tenis = new Deporte("Tenis", "Dificil");
        Deporte futbol = new Deporte("Futbol", "Fácil");

        deportes.add(futbol);
        deportes.add(tenis);
        deportes.add(hockey);
        deportes.add(volley);
        deportes.add(waterpolo);
        deportes.add(basquet);

        personas.add(new Persona("Daniel", "Otero", 26, Arrays.asList(futbol, volley)));
        personas.add(new Persona("Jose", "Sandona", 27, Arrays.asList(hockey, basquet, tenis)));
        personas.add(new Persona("Romina", "Delgado", 30, new ArrayList<>()));
        personas.add(new Persona("Mayra", "Torres", 27, Arrays.asList(basquet)));
        personas.add(new Persona("Mariana", "Madeira", 30, new ArrayList<>()));

    }

    public List<Deporte> getAllDeportes() {
        return this.deportes;
    }

    public List<Persona> getAllPersonas() {
        return this.personas;
    }

}
