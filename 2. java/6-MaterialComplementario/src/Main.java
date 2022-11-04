import Ejercicio1.EstudianteTecnico;
import Ejercicio1.Mantenimiento;
import Ejercicio1.Profesor;
import Ejercicio1.Tutor;
import Ejercicio2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println(" ========================== Ejercicio 1 ========================== ");

        List<String> reparaciones = new ArrayList<>();
        reparaciones.add("Reparar 1");
        reparaciones.add("Reparar 2");

        List<String> clases= new ArrayList<>();
        clases.add("Clase 1");
        clases.add("Clase 2");

        EstudianteTecnico estudianteTecnico1 = new EstudianteTecnico("Estudiante",
                "Técnico",
                123456,
                "ABC123",
                reparaciones);

        Mantenimiento mantenimiento = new Mantenimiento("Mantenimiento",
                "Apellido",
                123456,
                "123ABC");

        Profesor profesor = new Profesor("Profesor",
                "Apellido",
                123456,
                "123ABCD",
                "Economía");

        Tutor tutor = new Tutor("Tutor",
                "Estudiante",
                123456,
                "ABC1234",
                clases);

        System.out.println("*****************************************************");
        estudianteTecnico1.anunciarse();
        estudianteTecnico1.reparar();
        estudianteTecnico1.estudiar();

        System.out.println("*****************************************************");
        mantenimiento.anunciarse();
        mantenimiento.trabajar();

        System.out.println("*****************************************************");
        profesor.anunciarse();
        profesor.enseniar();
        profesor.trabajar();

        System.out.println("*****************************************************");
        tutor.anunciarse();
        tutor.estudiar();
        tutor.enseniar();

        System.out.println(" ========================== Ejercicio 2 ========================== ");

        // Inicia el juego
        Juego juego = new Juego();

        // Creamos listados de puntosEspacios para ser usados por asteroides y naves
        PuntoEspacio puntoEspacio1 = new PuntoEspacio(1.0, 7.0);
        PuntoEspacio puntoEspacio2 = new PuntoEspacio(2.0, 8.0);
        PuntoEspacio puntoEspacio3 = new PuntoEspacio(3.0, 9.0);
        PuntoEspacio puntoEspacio4 = new PuntoEspacio(4.0, 10.0);
        PuntoEspacio puntoEspacio5 = new PuntoEspacio(5.0, 11.0);
        PuntoEspacio puntoEspacio6 = new PuntoEspacio(6.0, 12.0);

        // Creamos los asteroides
        Asteroide asteroide1 = new Asteroide(puntoEspacio1);
        Asteroide asteroide2 = new Asteroide(puntoEspacio2);

        // Creamos las naves
        NaveSimple naveSimple1 = new NaveSimple("Nave1", puntoEspacio3, 0.0);
        NaveSimple naveSimple2 = new NaveSimple("Nave2", puntoEspacio4, 0.0);
        NaveSimple naveSimple3 = new NaveSimple("Nave3", puntoEspacio5, 0.0);
        NaveSimple naveSimple4 = new NaveSimple("Nave4", puntoEspacio6, 0.0);

        // Creamos una flota
        List<NaveSimple> flotaNaves = new ArrayList<>();
        flotaNaves.add(naveSimple1);
        flotaNaves.add(naveSimple2);

        FlotaNaves flotaNaves1 = new FlotaNaves(flotaNaves, 0.0);

        // Listados de asteroides y de naves
        List<Asteroide> asteroides = new ArrayList<>();
        asteroides.add(asteroide1);
        asteroides.add(asteroide2);

        List<IUnidadDefensa> navesFlotas = new ArrayList<>();
        navesFlotas.add(flotaNaves1);
        navesFlotas.add(naveSimple3);
        navesFlotas.add(naveSimple4);

        // Registramos los asteroides y las naves en el juego
        Juego juego1 = new Juego(asteroides, navesFlotas);

        // Iniciamos el juego
        juego1.iniciarJuego();

        System.out.println("-------------- Cálculos de puntajes y ganandores -----------------------");
        juego1.calcularGanadores(asteroides, navesFlotas);
    }
}