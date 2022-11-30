package com.example.Deportista.repository;

import com.example.Deportista.entity.Deporte;
import com.example.Deportista.entity.Persona;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class DeportistasRepository {
     static ArrayList<Persona> personas = new ArrayList<>(){
        {
            add(new Persona("Juan","Torres",23,"Ciclismo"));
            add(new Persona("Andres","Perez",30,"tennis"));
            add(new Persona("Carlos","uribe",19,"futbol"));
        }

    };

     public static ArrayList<Persona> getPersonas( ){
         return personas;
     }
}
