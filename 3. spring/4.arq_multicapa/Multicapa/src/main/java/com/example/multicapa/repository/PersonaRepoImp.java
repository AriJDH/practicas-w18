package com.example.multicapa.repository;

import com.example.multicapa.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImp implements IPersonaRepository{

    List<Persona> personas = new ArrayList<>();

    public PersonaRepoImp(){
        this.cargar();
    }

    @Override
    public List<Persona> findAllPersonas() {

        return personas;
    }

    private void cargar(){
        personas.add(new Persona("Jose","Peres",22));
        personas.add(new Persona("Maria","Pres",22));
        personas.add(new Persona("Mariana","Peres",22));
        personas.add(new Persona("Sol","Peres",22));
        personas.add(new Persona("Pipo","Peres",22));

    }
}
