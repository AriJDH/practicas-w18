package com.deportista.clase2.repo;

import com.deportista.clase2.entity.Deporte;
import com.deportista.clase2.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class RepoPersonas {
    private static ArrayList<Persona> personas = new ArrayList<Persona>();

    static{
        personas.add(new Persona("Iavana", "Cingolani", 39, new ArrayList<Deporte>()));
        personas.add(new Persona("Maria", "Ramirez", 27, new ArrayList<Deporte>()));
        personas.add(new Persona("Federico", "Paz", 26, new ArrayList<Deporte>()));
        personas.add(new Persona("Nicolas", "Sanchez", 30, new ArrayList<Deporte>()));
    }
    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
}