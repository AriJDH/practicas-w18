package Ejercicio1Universidad.Clases;

import Ejercicio1Universidad.Interfaces.IDarSoporte;

public class Soporte extends Personal implements IDarSoporte {

    public Soporte(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void darSoporteTecnico() {
        System.out.println("Dando soporte...");
    }
}
