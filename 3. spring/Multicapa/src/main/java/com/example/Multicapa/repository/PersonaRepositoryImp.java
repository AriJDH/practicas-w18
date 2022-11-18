package com.example.Multicapa.repository;

import com.example.Multicapa.entity.Persona;
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
        personas.add(new Persona("Martín","Perez",30));
        personas.add(new Persona("Mariana","Perez",30));
        personas.add(new Persona("Pedro","Perez",30));
        personas.add(new Persona("Juan","Perez",30));
        personas.add(new Persona("Pipo","Perez",30));
        personas.add(new Persona("Candela","Perez",30));

    }


}
