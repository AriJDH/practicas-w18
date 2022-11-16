package InterfacesYClaseAbstractas.juego.clases;

import InterfacesYClaseAbstractas.juego.interfaces.Mostrable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Juego implements Mostrable {

    private List<Asteroide> asteroides = new ArrayList<>();
    private List<Jugador> jugadores = new ArrayList<>();

    public Juego() {
        double cantidadJugadores = Math.floor(Math.random() * (5 - 2 + 1) + 2);
        double cantidadAsteroides = Math.floor(Math.random() * (5 - 2 + 1) + 2);

        for (int i  = 0; i < cantidadJugadores; i++ ) {
            Jugador jugador = new Jugador();
            jugadores.add(jugador);
        }

        for (int i  = 0; i < cantidadAsteroides; i++ ) {
            Asteroide asteroide = new Asteroide();
            asteroides.add(asteroide);
        }
    }

    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void puntuar() {
        List<Jugador> jugadores = new ArrayList<>();

        getAsteroides().stream().forEach(asteroide -> {
            AtomicReference<Jugador> minimo = new AtomicReference<>(getJugadores().get(0));
            getJugadores().stream()
                    .forEach(jugador -> {
                if (jugador
                        .getDefensa()
                        .calcularDistancia(asteroide) <
                        minimo
                                .get()
                                .getDefensa()
                                .calcularDistancia(asteroide)
                )  minimo.set(jugador);
            });
            minimo.get().setPuntaje();
            minimo.get().setDistanciasGanadoras(
                    minimo.get()
                            .getDefensa()
                            .calcularDistancia(asteroide));
            jugadores.add(minimo.get());
        });
    }

    public void mostrarCompetidores() {
        getJugadores()
                .stream()
                .sorted(
                        Comparator
                                .comparing(Jugador::getPuntaje))
                .forEach(System.out::println);
    }

    @Override
    public void mostrar() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return   "asteroides.."
                + '\n' + getAsteroides() + '\n' +
                "jugadores..:" + '\n' + getJugadores() ;
    }
}
