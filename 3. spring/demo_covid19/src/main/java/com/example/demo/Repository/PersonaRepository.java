package com.example.demo.Repository;

import com.example.demo.Interfaces.CrudRepository;
import com.example.demo.entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaRepository implements CrudRepository<Persona> {
    List<Persona> personaList = new ArrayList<>();

    @Override
    public List<Persona> getData() {
        Persona persona1 = new Persona(1,"Fulanito","Loaiza", 30);
        Persona persona2 = new Persona(1,"Andrea","Pirlo", 61);
        Persona persona3 = new Persona(1,"Yei yei","Ococha", 18);
        personaList.add(persona1);
        personaList.add(persona2);
        personaList.add(persona3);
        return personaList;
    }

    @Override
    public Persona getData(String objeto) {
        this.getData();
        Persona personaResult = new Persona();
        if ((Persona) personaList.stream().filter(w->w.getNombre().equals(objeto))!= null);
        {
            personaResult = (Persona) personaList.stream().filter(w->w.getNombre().equals(objeto));
        }
        return personaResult;
    }
}
