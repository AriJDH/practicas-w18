package com.meli.lgutierrez.clase3.ejercicioPractico2;

public class Persona {
    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + ", con DNI: " + dni;
    }
}
