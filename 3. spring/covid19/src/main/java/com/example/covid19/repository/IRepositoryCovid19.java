package com.example.covid19.repository;

import com.example.covid19.entity.Person;
import com.example.covid19.entity.Symptom;
import java.util.List;

public interface IRepositoryCovid19 {
    public List<Symptom> getAllSymptoms();
    public Symptom findByName(String name);
    public List<Person> getAllPeople();
}
