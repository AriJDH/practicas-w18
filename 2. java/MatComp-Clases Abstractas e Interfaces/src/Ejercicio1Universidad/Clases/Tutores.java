package Ejercicio1Universidad.Clases;

import Ejercicio1Universidad.Interfaces.IDarClase;

public class Tutores extends Estudiante implements IDarClase {

    public Tutores(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void darClase() {
        System.out.println("Dando clases...");
    }
}
