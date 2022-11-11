package com.jcundere.ejerciciopractico04.repository;

import com.jcundere.ejerciciopractico04.entity.Deporte;
import com.jcundere.ejerciciopractico04.entity.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaImp implements CRUDRepository<Persona> {

    private List<Persona> listaPersonas = new ArrayList<>();


    public PersonaImp() {
        listaPersonas.add(new Persona("Juan", "Perez", 34));
        listaPersonas.add(new Persona("Maria", "Gomez", 23));
        listaPersonas.add(new Persona("Elisa", "Sanchez", 54));
        listaPersonas.add(new Persona("Jorge", "Rodriguez", 12));
        listaPersonas.add(new Persona("Laura", "Paz", 99));

        listaPersonas.get(2).agregaDeporta(new Deporte("Boxeo", "Intermedio"));

        listaPersonas.get(1).agregaDeporta(new Deporte("Futbol", "Intermedio"));

    }


    public Optional<Persona> buscar(String nombre) {
        for (Persona persona : listaPersonas
        ) {
            if (persona.getNombre().equals(nombre)) {
                return Optional.of(persona);
            }
        }
        return Optional.empty();
    }

    public List<Persona> traeTodos() {
        return listaPersonas;
    }

    public void save(Persona persona) {
        listaPersonas.add(persona);
    }

}
