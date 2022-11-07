package org.example.models;

import java.util.List;

public class Tutores extends Estudiantes implements IEnseniable{

    private List<String> materias;

    public Tutores(String name, String lastName, int dni, int year, int legajo, List<String> materias) {
        super(name, lastName, dni, year, legajo);
        this.materias = materias;
    }

    @Override
    public void tutor() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ". Legajo: " + getLegajo() + ", estudiante técnico y parte del grupo docente.");
    }

    public void enseniar() {
        System.out.println("Enseñando las materias: \n" + materias);
    }
}
