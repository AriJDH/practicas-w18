package com.example.demo.Repository;

import com.example.demo.Interfaces.CrudRepository;
import com.example.demo.entity.Persona;
import com.example.demo.entity.PersonaSintomas;
import com.example.demo.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RiskRepository implements CrudRepository<PersonaSintomas> {
    List<PersonaSintomas> personaSintomasList = new ArrayList<>();

    @Override
    public List<PersonaSintomas> getData() {
        SintomaRepository sintomaRepository = new SintomaRepository();
        PersonaRepository personaRepository = new PersonaRepository();

        List<Persona> personaList = personaRepository.getData();
        List<Sintoma> sintomaList = sintomaRepository.getData();

        for (Persona p: personaList) {
            PersonaSintomas personaSintomas = new PersonaSintomas();
            personaSintomas.setPersona(p);
            Random r = new Random();
            List<Sintoma> listS = new ArrayList<>();
            for (int i = 0; i < r.nextInt(5)+1; i++){
                listS.add(sintomaList.get(i));
            }
            personaSintomas.setSintomaList(listS);
            personaSintomasList.add(personaSintomas);
        }

        return personaSintomasList;
    }

    @Override
    public PersonaSintomas getData(String objeto) {
        return null;
    }
}
