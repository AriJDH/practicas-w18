package com.meli.Documents;

import java.util.List;

public class Person {
    private String Nombre;
    private int Age;
    private List<String> skills;

    public Person(String nombre, int age, List<String> skills) {
        Nombre = nombre;
        Age = age;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "{" +
                "Nombre='" + Nombre + '\'' +
                ", Age=" + Age +
                ", skills=" + skills +
                '}';
    }
}
