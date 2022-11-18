package com.example.covid.repository;

import com.example.covid.entity.Person;

import java.util.List;

public interface IPersonaRepository {
    List<Person> findRiskPerson();

}
