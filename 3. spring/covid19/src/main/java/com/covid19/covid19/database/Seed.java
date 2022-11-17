package com.covid19.covid19.database;

import com.covid19.covid19.entities.Level;
import com.covid19.covid19.entities.Person;
import com.covid19.covid19.entities.Symptom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class Seed {
    List<Person> persons = new ArrayList<>();
    List<Symptom> symptoms = new ArrayList<>();
    public Seed() {


        Symptom s1 = new Symptom(123,"Dolor de panza", Level.Intermedio);
        Symptom s2 = new Symptom(321,"Hemorragia intracerebral", Level.Grave);
        Symptom s3 = new Symptom(132,"Fiebre", Level.Leve);
        Symptom s4 = new Symptom(213,"Perdida de vision", Level.Grave);
        Symptom s5 = new Symptom(231,"Perdida del gusto", Level.Intermedio);
        Symptom s6 = new Symptom(312,"Perdida de pelo", Level.Grave);

        List<Integer> sl1 = new ArrayList<>();
        List<Integer> sl2 = new ArrayList<>();
        List<Integer> sl3 = new ArrayList<>();
        List<Integer> sl4 = new ArrayList<>();
        sl1.add(321);
        sl2.add(123);
        sl2.add(132);
        sl3.add(213);
        sl3.add(312);
        sl4.add(312);
        sl4.add(321);

        Person p1 = new Person(15,"Axel","Palombo",25, sl1);
        Person p2 = new Person(143242, "Anibal", "Presa", 23, sl2);
        Person p3 = new Person(94949,"Leandro", "Sanchez", 15, sl3);
        Person p4 = new Person(85858, "Ricardo", "Ochoa", 99, sl4);

        Collections.addAll(symptoms, s1,s2,s3,s4,s5,s6);
        Collections.addAll(persons, p1,p2,p3,p4);
    }
}
