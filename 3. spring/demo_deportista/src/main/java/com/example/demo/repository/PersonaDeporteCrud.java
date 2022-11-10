package com.example.demo.repository;

import com.example.demo.entity.Deporte;
import com.example.demo.entity.PersonaDeporte;
import com.example.demo.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaDeporteCrud implements CrudRepository<PersonaDeporte> {
    List<PersonaDeporte> personaDeportelist = new ArrayList<>();

    @Override
    public void guardar(PersonaDeporte objeto) {
        personaDeportelist.add(objeto);
    }

    @Override
    public List<PersonaDeporte> buscar(String name) {
        List<PersonaDeporte> buscar = new ArrayList<>();
        buscar = personaDeportelist.stream().filter(pd-> pd.getPersona().getNombre().equals(name)).collect(Collectors.toList());
        return buscar;
    }

    @Override
    public List<PersonaDeporte> listar() {
        return personaDeportelist;
    }


}
