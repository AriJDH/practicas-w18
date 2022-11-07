package org.example.models;

import java.util.List;

public class Profesores extends Personal implements IEnseniable{

    private List<String> materias;

    public Profesores(String name, String lastName, int dni, int year, List<String> materias) {
        super(name, lastName, dni, year);
        this.materias = materias;
    }

    @Override
    public void tutor() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ". Profesor de la institución.");
    }

    public void enseniar() {
        System.out.println("Enseñando las materias: \n" + materias);
    }
}
