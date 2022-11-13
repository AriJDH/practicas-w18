package com.example.covid19.repository;

import com.example.covid19.entity.Persona;
import com.example.covid19.entity.Sintoma;

import java.util.List;

public interface IRepository {
    List<Sintoma> findSymptom();
    Sintoma findSymtom(String name);
    //List<Persona> findPerson();
    List<Persona> findRiskPerson();
}
