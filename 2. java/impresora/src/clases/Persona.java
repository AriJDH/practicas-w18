package clases;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;
    private List<String> habilidades;

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = new ArrayList<>();
    }


    public void agregarHabilidad(String habilidad){

        habilidades.add(habilidad);

    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
}
