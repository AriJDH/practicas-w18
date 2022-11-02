package clases;

import java.util.ArrayList;

public class Juego {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Juego(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void iniciarJuego(double x, double y){
        double min = Integer.MAX_VALUE;
        double distancia = 0;
        int pos = 0;

        for(int i = 0; i < this.jugadores.size(); i++){
            distancia = this.jugadores.get(i).jugar(x, y);
            if (distancia < min){
                min = distancia;
                pos = i;
            }
        }

        this.jugadores.get(pos).sumarPunto();


        System.out.println("El jugador que se lleva el punto " + this.jugadores.get(pos).getNombre() + " con puntos " + this.jugadores.get(pos).puntosJugador());


    }
    public void mostrarJugadores(){
        System.out.println("------ Iniciano juego ------");
        System.out.println("Los jugadores son " + this.jugadores.toString());
    }
    public void terminarJuego(){
        System.out.println("Puntos de jugadores: ");
        for (Jugador jugador: this.jugadores) {
            System.out.println(jugador.getNombre() + " = " + jugador.puntosJugador());
        }
    }

    public void inscribirJugadores(String nombre, int eleccion, String naveNombre){
        jugadores.add(new Jugador(nombre, eleccion, naveNombre));
    }
}
