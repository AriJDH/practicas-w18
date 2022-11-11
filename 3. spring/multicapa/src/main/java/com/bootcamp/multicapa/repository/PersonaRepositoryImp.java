package com.bootcamp.multicapa.repository;

import com.bootcamp.multicapa.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoryImp implements IPersonaRepository{

    @Override
    public List<Persona> creaListaPersona() {
        List<Persona> listPersonas = new ArrayList<Persona>();
        Persona listPerson = new Persona("Janeth", "Martinez", 29);
        Persona listPerson1 = new Persona("Janeth", "Martinez", 29);
        Persona listPerson2 = new Persona("Janeth", "Martinez", 29);
        Persona listPerson3 = new Persona("Janeth", "Martinez", 29);
        listPersonas.add(listPerson);
        listPersonas.add(listPerson1);
        listPersonas.add(listPerson2);
        listPersonas.add(listPerson3);
        return listPersonas;
    }
}
