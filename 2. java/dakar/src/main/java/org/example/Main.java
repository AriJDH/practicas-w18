package org.example;

import org.example.domain.*;

public class Main {
    public static void main(String[] args) {
        SocorristaAuto socorristaAuto = new SocorristaAuto(50, 6, 7, "ssss", 500, 4);
        SocorristaMoto socorristaMoto = new SocorristaMoto(50, 6, 7, "mmmm", 500, 4);

        Carrera carrera = new Carrera(1000, 10000, "La carrera del desierto", 2, socorristaAuto, socorristaMoto);
        carrera.darDeAltaAuto(200, 10, 5, "autoauto");
        carrera.darDeAltaMoto(100, 20, 10, "motomoto");

        System.out.println("Patente ganador:");
        System.out.println(carrera.getGanador().getPatente());
        System.out.println("Socorro de auto: ");
        carrera.socorrerAuto("autoauto");
        System.out.println("Socorro de moto: ");
        carrera.socorrerMoto("motomoto");
    }
}