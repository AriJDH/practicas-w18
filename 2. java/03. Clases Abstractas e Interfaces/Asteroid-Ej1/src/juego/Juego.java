package juego;

import java.util.Collections;
import java.util.List;

public class Juego {
    List<Jugador> jugadores;
    List<Asteroide> asteroides;

    public Juego(List<Jugador> participantes, List<Asteroide> asteroides) {
        this.jugadores = participantes;
        this.asteroides = asteroides;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public List<Asteroide> getAstroides() {
        return asteroides;
    }

    public void atacarAsteroides() {
        Jugador jugadorConMenorDistancia;
        double distanciaMenor;
        double distancia;
        Coordenada coordenadaAsteroide;
        for (Asteroide a : asteroides) {
            jugadorConMenorDistancia=null;
            distanciaMenor = Double.MAX_VALUE;
            coordenadaAsteroide = a.getCoordenada();
            for (Jugador j : jugadores) {
                distancia = j.getUnidadDeAtaque().calcularDistancia(coordenadaAsteroide);
                j.agregarDistancia(distancia);
                if(distancia<distanciaMenor){
                    jugadorConMenorDistancia=j;
                    distanciaMenor = distancia;
                }
            }
            jugadorConMenorDistancia.sumarPuntaje();
        }
        Collections.sort(this.jugadores);
    }

    public void mostrarTablaDePuntuaciones(){
        this.jugadores.forEach((j)-> System.out.println("Nombre: "+ j.getNombre() + "\n\tPuntaje= "+ j.getPuntuacion()));
    }

    public void mostrarGanador(){
        System.out.println("EL GANADOR ES: ");
        System.out.println(this.jugadores.get(0));
    }

}
