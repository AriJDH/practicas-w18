package Ejercicio2;

public class Asteroide {

    private PuntoEspacio puntoEspacio;

    public Asteroide(PuntoEspacio puntoEspacio) {
        this.puntoEspacio = puntoEspacio;
    }

    public PuntoEspacio getPuntoEspacio() {
        return puntoEspacio;
    }

    @Override
    public String toString() {
        return "\n         <<<Asteroide>>> \n" + puntoEspacio + "\n >>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<< \n";
    }
}
