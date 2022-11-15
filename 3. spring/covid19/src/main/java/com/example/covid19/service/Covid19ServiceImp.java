package com.example.covid19.service;

import com.example.covid19.entity.Person;
import com.example.covid19.entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Covid19ServiceImp implements ICovid19Service{
    @Override
    public List<Symptom> getSymptons() {
        return null;
    }

    @Override
    public Symptom getSymptonsByName(String name) {
        return null;
    }

    @Override
    public List<Person> getRiskPeople() {
        return null;
    }
}
