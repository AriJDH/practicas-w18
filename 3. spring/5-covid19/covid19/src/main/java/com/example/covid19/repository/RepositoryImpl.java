package com.example.covid19.repository;

import com.example.covid19.entity.Persona;
import com.example.covid19.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryImpl implements IRepository {
    List<Persona> personaList = new ArrayList<>();
    List<Sintoma> sintomaList = new ArrayList<>();

    public RepositoryImpl() {
        this.loadPerson();
        this.loadSymtomp();
    }

    @Override
    public List<Sintoma> findSymptom() {
        return sintomaList;
    }

    public List<Persona> findPerson() {
        return personaList;
    }

    @Override
    public List<Persona> findRiskPerson() {
        List<Persona> riskPerson;
        riskPerson = personaList.stream().filter(persona -> persona.getAge() >= 60).collect(Collectors.toList());
        return riskPerson;
    }

    @Override
    public Sintoma findSymtom(String name) {
        for (Sintoma symptom: sintomaList) {
            if(symptom.getNameSymptom().equals(name)){
                return symptom;
            }
        }
        return null;
    }

    private void loadPerson() {
        personaList.add(new Persona(123, "Jose", "Perez", 22, "tos"));
        personaList.add(new Persona(234, "Jose", "Perez", 70, "tos"));
        personaList.add(new Persona(345, "Marta", "Lopez", 60, "falta oxigeno"));
        personaList.add(new Persona(456, "Sol", "Martinez", 30, "falta oxigeno"));
    }

    private void loadSymtomp() {
        sintomaList.add(new Sintoma(111, "Tos", "Grave"));
        sintomaList.add(new Sintoma(234, "Falta de oxigeno", "Grave"));
        sintomaList.add(new Sintoma(123, "Falta de oxigeno", "Grave"));
    }


}
