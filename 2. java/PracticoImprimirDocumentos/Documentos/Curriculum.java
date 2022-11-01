package Documentos;

import Interfaz.Interfaz;

import java.util.Arrays;

public class Curriculum implements Interfaz {
    private String apellido;
    private String nombre;
    private int edad;
    private String dni;
    private String[] habilidades;

    public Curriculum(String apellido, String nombre, int edad, String dni, String[] habilidades) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }

}
