package org.example.models;

public class Personal extends Persona{

    public Personal(String name, String lastName, int dni, int year) {
        super(name, lastName, dni, year);
    }

    @Override
    public void presentarse() {
        System.out.println("Soy " + getLastName() + ", " + getName() + ".\nD.N.I.: " + getDni() + " miembro del personal.");
    }
}
