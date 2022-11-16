package InterfacesYClaseAbstractas.juego.interfaces;

import InterfacesYClaseAbstractas.juego.clases.NaveSimple;

import java.util.ArrayList;
import java.util.List;

public interface Creable {

    String nombreNaves[] = {
            "T-65",
            "Halcón Milenario",
            "Aerodeslizador T46",
            "TIE Avanzado X1",
            "Caza Estelar N-1",
            "Destructor Estelar"
    };

    String jugadores[] = {
            "Cassian Jeron Andor",
            "Hera Syndulla",
            "Garazeb Orrelios",
            "Quarsh Panaka",
            "Bragg",
            "Greez Dritus"
    };
    static NaveSimple crearNave() {
        NaveSimple nave = new NaveSimple(crearNombre(), crearCoordenada(), crearCoordenada());
        return nave;
    }

    static List<NaveSimple> crearFlota() {
        int cantidadNaves = (int) Math.floor(Math.random() * (5 - 2 + 1) + 2);
        List<NaveSimple> flota = new ArrayList<>();

        for (int i = 0; i < cantidadNaves; i++ ) {
            flota.add(crearNave());
        }

        return flota;
    }

    static String crearNombre() {
        int indice = (int) Math.floor(Math.random() * 6);

        return nombreNaves[indice];
    }

    static Double crearCoordenada() {
        double x = Math.random() * 10 + 1;

        return x;
    }

    static String crearNombreJugador() {
        int indice = (int) Math.floor(Math.random() * 6);

        return jugadores[indice];
    }
}
