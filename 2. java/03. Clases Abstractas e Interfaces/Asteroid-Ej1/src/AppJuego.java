import juego.*;

import java.util.ArrayList;
import java.util.List;

public class AppJuego {
    public static void main(String[] args) {
        CargaDeDatosUtil cd = new CargaDeDatosUtil();
        List<Jugador> listaJugadores = new ArrayList<>();
        int opcion;
        int nroNaves;
        Jugador jugador=null;
        for (String n : cd.getNombres()) {
            opcion = (int) cd.getNroRandom(0,1);
            switch (opcion) {
                case 0:
                    nroNaves = (int) cd.getNroRandom(2,10);
                    Flota flota = new Flota();
                    for (int i = 2; i<nroNaves;i++){
                        flota.agregarNave(cd.getNaveRandom());
                    }
                    jugador = new Jugador(n, flota);
                    break;
                case 1:
                    jugador = new Jugador(n, cd.getNaveRandom());
                    break;
                default:
                    System.err.println("Opción no válida");
            }
            listaJugadores.add(jugador);
        }

        List<Asteroide> listaAsteroides = new ArrayList<>();
        int cantidadDeAsteroides = (int) cd.getNroRandom(5,20);
        for (int i = 0; i < cantidadDeAsteroides; i++) {
            listaAsteroides.add(new Asteroide(cd.getCoordenadaRandom()));
        }

        Juego juego = new Juego(listaJugadores,listaAsteroides);
        juego.atacarAsteroides();
        System.out.println("**********************************");
        juego.mostrarGanador();
        System.out.println("**********************************");
        //juego.mostrarTablaDePuntuaciones();
        //System.out.println(juego.getJugadores());

    }
}
