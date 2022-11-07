package org.example.models;

public class Estudiantes extends Persona{

    private int legajo;

    public Estudiantes(String name, String lastName, int dni, int year, int legajo) {
        super(name, lastName, dni, year);
        this.legajo = legajo;
    }

    @Override
    public void presentarse() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ".\nLegajo: " + legajo + " estudiante de la institución.");
    }

    public int getLegajo() {
        return legajo;
    }
}
