package org.example.models;

public abstract class Persona {

    private String name;
    private String lastName;
    private int dni;
    private int year;

    public Persona(String name, String lastName, int dni, int year) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract void presentarse();

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", year=" + year +
                '}';
    }
}
