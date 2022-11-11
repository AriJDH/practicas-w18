package com.example.demo.repository;

import com.example.demo.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository{

    List<Persona> personas = new ArrayList<>();

    public PersonaRepositoryImp(){
        this.cargar();
    }

    @Override
    public List<Persona> findAll() {
        return personas;
    }

    private void cargar(){
        personas.add(new Persona("jose", "perez", 30));
        personas.add(new Persona("josefina", "perez", 30));
        personas.add(new Persona("ibrahin", "perez", 30));
        personas.add(new Persona("estefania", "perez", 30));
        personas.add(new Persona("maria", "perez", 30));
        personas.add(new Persona("moni", "perez", 30));
    }
}
