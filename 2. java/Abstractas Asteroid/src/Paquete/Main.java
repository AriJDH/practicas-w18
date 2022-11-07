package Paquete;

import Clases.FlotaNaves;
import Clases.Naves;
import Interfaces.INaves;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<INaves> listaJugadores = new ArrayList<>();  //Siendo de tipo Inaves obligo que solo se puedan meter cosas que lo implementan.
        double puntajeGanador;
        INaves ganador;

        //Inscripcion de jugadores es igual a inscirbir las naves y flotas.
        //Inscribir nave sola
        Naves naveInscrita = new Naves("Participante 1",1,1);
        listaJugadores.add(naveInscrita);

        //Inscribir flota
        FlotaNaves flotaInscrita=new FlotaNaves("Participante 2");
        Naves naveFlota1 = new Naves("nave 1",2,1);
        Naves naveFlota2= new Naves("nave 2",2,1);
        Naves naveFlota3 = new Naves("nave 3",3,1);
        flotaInscrita.agregarNave(naveFlota1);
        flotaInscrita.agregarNave(naveFlota2);
        flotaInscrita.agregarNave(naveFlota3);
        listaJugadores.add(flotaInscrita);

        //Comenzar juego. Para blanco= 0,0
        //Determinar ganador
        int xBlanco=0;
        int yBlanco=0;
        puntajeGanador=listaJugadores.get(0).calcularDistancia(xBlanco   ,yBlanco);
        ganador=listaJugadores.get(0);


        for(INaves jugadores : listaJugadores){
            System.out.println("Para el "+ jugadores.getNombre());
            System.out.println("Sus coordenadas son: " + jugadores.getCoordenadas() );
            System.out.println("Por ende su puntaje es: "+jugadores.calcularDistancia(xBlanco   ,yBlanco));
            System.out.println(" ");

            if (jugadores.calcularDistancia(xBlanco   ,yBlanco) < puntajeGanador) {
                puntajeGanador=jugadores.calcularDistancia(xBlanco   ,yBlanco);
                ganador=jugadores;
            }

        }
        System.out.println("El ganador es "+ ganador.getNombre());
    }
}
