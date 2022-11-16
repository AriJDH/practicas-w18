package Ejercicio1Universidad.Clases;

import Ejercicio1Universidad.Interfaces.IDarClase;

public class Profesor extends Persona implements IDarClase {

    public Profesor(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void darClase() {
        System.out.println("Dando clases...");
    }
}
