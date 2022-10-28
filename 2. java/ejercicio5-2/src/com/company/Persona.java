package com.company;

import java.util.ArrayList;


public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private ArrayList <String> habilidades = new ArrayList<>();

    public Persona() {
    }

    public Persona(String nombre, int edad, int dni, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }
}
