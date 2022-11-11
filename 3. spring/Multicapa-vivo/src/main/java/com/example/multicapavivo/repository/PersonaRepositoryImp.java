package com.example.multicapavivo.repository;

import com.example.multicapavivo.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository {

    List<Persona> personas;

    public PersonaRepositoryImp() {
        this.personas = new ArrayList<>();
        cargar();
    }

    @Override
    public List<Persona> findAll() {
        return personas;
    }

    private void cargar(){
        personas.add(new Persona("jonathan","caucota",25));
        personas.add(new Persona("ariel","jaime",31));
        personas.add(new Persona("martin","perez",35));
        personas.add(new Persona("jose","caucota",53));
        personas.add(new Persona("leila","limoli",40));
    }
}
