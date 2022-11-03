package Ejercicio2;

public class Asteroide {

    // Atributos
    private PuntoEspacio puntoEspacio;

    // Constructores
    public Asteroide(PuntoEspacio puntoEspacio) {
        this.puntoEspacio = puntoEspacio;
    }

    // Getters
    public PuntoEspacio getPuntoEspacio() {
        return puntoEspacio;
    }

    // Métodos
    @Override
    public String toString() {
        return "\n         <<<Asteroide>>> \n" + puntoEspacio + "\n >>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<< \n";
    }
}
