package com.example.multicapa.demo.repository;

import com.example.multicapa.demo.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PersonaRepositoryImp implements IPersonaRepository{

    List<Persona> personas = new ArrayList<>();

    public PersonaRepositoryImp(){
        cargarPersonas();
    }

    @Override
    public List<Persona> findAll(){
        return personas;
    }

    private void cargarPersonas(){
        personas.add(new Persona("Martin", "Perez",33));
        personas.add(new Persona("Mariana", "Perez",33));
        personas.add(new Persona("Pedro", "Perez",33));
        personas.add(new Persona("Juan", "Perez",33));
        personas.add(new Persona("Jose", "Perez",33));
        personas.add(new Persona("Candela", "Perez",33));
    }

    @Override
    public List<Persona> findAll() {
        return null;
    }
}
