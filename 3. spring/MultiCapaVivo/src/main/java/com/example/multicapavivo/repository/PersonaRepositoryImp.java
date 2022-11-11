package com.example.multicapavivo.repository;

import com.example.multicapavivo.entity.Persona;
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
        return this.personas;
    }

    private void cargar(){
        personas.add(new Persona("Jose", "Perez", 30));
        personas.add(new Persona("Mariana", "Perez", 31));
        personas.add(new Persona("Juana", "Perez", 33));
        personas.add(new Persona("Pedro", "Perez", 35));
    }
}
