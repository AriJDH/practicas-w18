package com.demomulticapa.demomulticapa.repository;

import com.demomulticapa.demomulticapa.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PersonaRepositoryImp implements IPersonaRepository{

    List<Persona> personas = new ArrayList<>();

    public PersonaRepositoryImp() {
        cargar();
    }

    @Override
    public List<Persona> findAll() {
        return personas;
    }

    private void cargar(){
        personas.add(new Persona("maria","perez",30));
        personas.add(new Persona("jose","campo",65));
        personas.add(new Persona("marisela","hoyos",25));
        personas.add(new Persona("campi","rama",42));
        personas.add(new Persona("pepota","pepito",45));
    }
}
