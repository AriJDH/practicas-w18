package com.spring.multicapa.repository;

import com.spring.multicapa.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository{
    List<Persona> personas = new ArrayList<>();

    public PersonaRepositoryImp(){
        cargar();
    }
    @Override
    public List<Persona> findAll() {
        return personas;
    }

    private void cargar(){
        personas.add(new Persona("Jose", "Perez", 30));
        personas.add(new Persona("Carlos", "Gonzalez", 30));
        personas.add(new Persona("Mariana", "Fernandez", 30));
    }
}
