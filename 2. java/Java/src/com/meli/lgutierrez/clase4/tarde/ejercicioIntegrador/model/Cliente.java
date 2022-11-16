package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model;

public class Cliente {

    private Integer dni;
    private String nombre;
    private String apellido;

    public Cliente() {
    }

    public Cliente(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "dni: " + dni + ", nombre: " + nombre + ", apellido: " + apellido + '.';
    }
}
