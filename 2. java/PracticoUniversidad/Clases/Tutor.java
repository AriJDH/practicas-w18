package Clases;

import Interfaces.IDarClase;

public class Tutor extends Estudiante implements IDarClase {
    public Tutor(String apellido, String nombre, int edad) {
        super(apellido, nombre, edad);
    }

    @Override
    public void brindarClase() {
        System.out.println("Dando clases...");
    }
}
