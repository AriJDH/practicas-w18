package com.example.deportistas.repositories;

import com.example.deportistas.domain.Deporte;
import com.example.deportistas.domain.Persona;

public class RepositoryFactory {
    private static PersonaRepository personaRepository = null;
    private static DeporteRepository deporteRepository = null;

    public static PersonaRepository getPersonaRepository(){
        if(personaRepository!=null)
                return personaRepository;
        else{
            personaRepository=new PersonaRepository();
            return personaRepository;
        }
    }

    public static DeporteRepository getDeporteRepository(){
        if(deporteRepository!=null)
            return deporteRepository;
        else{
            deporteRepository=new DeporteRepository();
            return deporteRepository;
        }
    }
}
