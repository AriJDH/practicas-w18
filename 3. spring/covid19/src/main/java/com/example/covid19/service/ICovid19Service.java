package com.example.covid19.service;

import com.example.covid19.entity.Person;
import com.example.covid19.entity.Symptom;

import java.util.List;

public interface ICovid19Service {
    public List<Symptom> getSymptons();
    public Symptom getSymptonsByName(String name);
    public List<Person> getRiskPeople();
}
