package ej2.Clases;

import java.util.ArrayList;

public class CV implements Imprimible{

    private String nombre, apellido, nacionalidad;
    private int edad;
    private ArrayList<String> cualidades;

    public CV(String nombre, String apellido, String nacionalidad, int edad, ArrayList<String> cualidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        this.cualidades = cualidades;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getCualidades() {
        return cualidades;
    }

    public void setCualidades(ArrayList<String> cualidades) {
        this.cualidades = cualidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo...");
        System.out.println("CV");
        System.out.println(nombre + " " + apellido);
        System.out.println(edad + " years old");
        System.out.println("Cualidades");
        for (String cualidad : cualidades){
            System.out.println(cualidad);
        }
    }
}
