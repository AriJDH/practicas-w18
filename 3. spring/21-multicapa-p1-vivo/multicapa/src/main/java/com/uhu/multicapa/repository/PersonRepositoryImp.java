package com.uhu.multicapa.repository;

import com.uhu.multicapa.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImp implements IPersonRepository{

    List<Person> personList = new ArrayList<>();

    public PersonRepositoryImp() {
        setup();
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    private void setup() {
        personList.add(new Person("James", "Jamison", 30));
        personList.add(new Person("Mary", "Maryland", 43));
        personList.add(new Person("Fred", "Freddington", 38));
        personList.add(new Person("Illia", "Ilooo", 18));
        personList.add(new Person("Braum", "Big", 76));
        personList.add(new Person("Arnold", "Arland", 14));
        personList.add(new Person("Terry", "Terrific", 44));
    }
}
