package com.example.covid19.repository;

import com.example.covid19.entity.Person;
import com.example.covid19.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryCovid19Imp implements IRepositoryCovid19{

    private List<Symptom> symptoms;
    private List<Person> people;

    public RepositoryCovid19Imp() {
        loadSymptoms();
        loadPeople();
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return symptoms;
    }

    @Override
    public Symptom findByName(String name) {
        return symptoms.stream()
                .filter(symptom -> symptom.getNombre().equals(name))
                .findFirst().get();
    }

    @Override
    public List<Person> getAllPeople() {
        return people;
    }

    private void loadSymptoms(){
        symptoms = new ArrayList<>();

        symptoms.add(new Symptom("1", "Fiebre",2));
        symptoms.add(new Symptom("2", "Tos",2));
        symptoms.add(new Symptom("3", "Escalos frios",3));
        symptoms.add(new Symptom("4", "Falta de aire",3));
    }

    private void loadPeople(){
        people = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<Symptom> symptomList = new ArrayList<>();
            int ramdon = (int) Math.random() * (symptoms.size() - 1);
            for (int j = 0; j < ramdon; j++) {
                ramdon = (int) Math.random() * (symptoms.size() - 1);
                symptomList.add(symptoms.get(ramdon));
            }
            people.add(new Person(i + 1, "Persona " + i, "Persona" + i, ramdon * 10, symptomList));
        }
    }
}
