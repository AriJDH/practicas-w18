package Ejercicio1Universidad.Clases;

import Ejercicio1Universidad.Interfaces.IDarSoporte;

public class Tecnico extends Estudiante implements IDarSoporte {

    public Tecnico(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void darSoporteTecnico() {
        System.out.println("Dando soporte...");
    }
}
