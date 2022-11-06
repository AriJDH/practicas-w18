package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{

    private String name;
    private String lastName;
    private int years;
    private List<String> skills;

    public Curriculum(String name, String lastName, int years, List<String> skills) {
        this.name = name;
        this.lastName = lastName;
        this.years = years;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum de " + lastName + ", " + name + ". Tiene " + years + " años de edad. \nLista de habilidades: " + skills.toString();
    }
}
