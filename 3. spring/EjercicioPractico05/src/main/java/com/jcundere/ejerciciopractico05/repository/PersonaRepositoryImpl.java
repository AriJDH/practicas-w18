package com.jcundere.ejerciciopractico05.repository;

import com.jcundere.ejerciciopractico05.entity.PersonaEntity;
import com.jcundere.ejerciciopractico05.entity.SintomaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonaRepositoryImpl implements CRUDRepository {

    private List<PersonaEntity> personaEntityList = new ArrayList<>();


    public PersonaRepositoryImpl(){

        personaEntityList.add(new PersonaEntity(1, "Raul", "Scalabrini", 45));
        personaEntityList.add(new PersonaEntity(2, "Antonio", "Bouchard", 83));
        personaEntityList.add(new PersonaEntity(3, "Angel", "Carranza", 10));
        personaEntityList.add(new PersonaEntity(4, "Cristina", "Lopez", 76));
        personaEntityList.add(new PersonaEntity(5, "Delfina", "Gomez", 60));

        personaEntityList.get(3).addSintomaEntity(new SintomaEntity("S6", "Dolor de Pecho", "Alta"));
        personaEntityList.get(3).addSintomaEntity(new SintomaEntity("S2", "Tos", "Baja"));

    }

    @Override
    public void save(Object objeto) {

    }

    @Override
    public Optional buscar(String nombre) {
        return Optional.empty();
    }

    @Override
    public List traeTodos() {
        return personaEntityList;
    }

}
