package com.example.covid.Repository;

import com.example.covid.Entity.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPersonaImp implements IRepository<Persona>{

    private List<Persona> personaList;

    public RepositoryPersonaImp() {
        this.personaList = new ArrayList<>();
    }

    @Override
    public List<Persona> listarTodos() {
        return personaList;
    }

    @Override
    public void agregar(Persona persona) {
        personaList.add(persona);
    }
}
