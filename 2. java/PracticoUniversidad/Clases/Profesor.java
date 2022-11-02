package Clases;

import Interfaces.IDarClase;

public class Profesor extends Persona implements IDarClase {
    public Profesor(String apellido, String nombre, int edad) {
        super(apellido, nombre, edad);
    }

    @Override
    public void brindarClase() {
        System.out.println("Dando clases...");
    }
}
