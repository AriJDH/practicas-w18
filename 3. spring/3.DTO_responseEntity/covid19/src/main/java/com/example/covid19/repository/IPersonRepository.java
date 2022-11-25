package com.example.covid19.repository;

import com.example.covid19.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonRepository {
    List<Person> riskPersons();
}
