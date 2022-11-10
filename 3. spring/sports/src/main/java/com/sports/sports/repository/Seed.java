package com.sports.sports.repository;

import com.sports.sports.models.Level;
import com.sports.sports.models.Person;
import com.sports.sports.models.Sport;

import java.util.ArrayList;
import java.util.List;

public class Seed {
    private static List<Person> persons = new ArrayList<>();
    private static List<Sport> sports = new ArrayList<>();

    public Seed() {

        Sport s1 = new Sport("Fulvol", Level.Amateur);
        Sport s2 = new Sport("Basketball", Level.SemiPro);
        Sport s3 = new Sport("Handball", Level.Pro);

        Person p1 = new Person("name1", "lastname1", 10, s1);
        Person p2 = new Person("name2", "lastname2", 20, s2);
        Person p3 = new Person("name3", "lastname3", 30, s3);
        Person p4 = new Person("Axel", "Palombo", 25, null);

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        sports.add(s1);
        sports.add(s2);
        sports.add(s3);
    }

    public  List<Person> getPersons() {
        return persons;
    }

    public  List<Sport> getSports() {
        return sports;
    }

}
