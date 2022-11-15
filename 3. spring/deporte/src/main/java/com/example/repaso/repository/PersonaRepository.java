package com.example.repaso.repository;

import com.example.repaso.entity.Deporte;
import com.example.repaso.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository {

    private static ArrayList<Persona> personas = new ArrayList<Persona>();

    static{
        //Rancio instanciar deportes aca, pero es pa ahorrar tiempo :P
        ArrayList<Deporte> deportes1 = new ArrayList<Deporte>();
        deportes1.add(new Deporte("Futbol", "Facil"));
        ArrayList<Deporte> deportes2 = new ArrayList<Deporte>();
        deportes2.add(new Deporte("Hockey", "Medio"));
        deportes2.add(new Deporte("Basket", "Dificil"));

        personas.add(new Persona("Ivana", "Cingolani", 39, new ArrayList<Deporte>()));
        personas.add(new Persona("Maria", "Ramirez", 27, deportes2));
        personas.add(new Persona("Federico", "Paz", 26, new ArrayList<Deporte>()));
        personas.add(new Persona("Nicolas", "Sanchez", 30, deportes1));
    }

    public static List<Persona> findSportsPersons(){
        return personas.stream().filter(p -> p.esDeportista()).collect(Collectors.toList());
    }
}
