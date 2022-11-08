package ejercicio2;

import ejercicio2.model.Carrera;

public class Main {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(3);
        carrera.darAltaAuto(100, 50, 45, "RDC316");
        carrera.darAltaAuto(140, 25, 50, "RDC315");
        carrera.darAltaMoto(15, 30, 25, "RDC314");

        carrera.socorrerAuto("RDC316");
        carrera.socorrerMoto("RDC314");

        carrera.eliminarVehiculoConPatente("RDC315");

        carrera.definirGanador();



    }
}
