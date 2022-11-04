package Ejercicio2;

import java.util.*;

public class Juego {

    // Atributos
    private List<Asteroide> asteroides;
    private List<IUnidadDefensa> unidadesDefensa;

    // Constructores
    public Juego() {

    }

    public Juego(List<Asteroide> asteroides, List<IUnidadDefensa> unidadesDefensa) {
        this.asteroides = asteroides;
        this.unidadesDefensa = unidadesDefensa;
    }

    // Getters
    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    public List<IUnidadDefensa> getUnidadesDefensa() {
        return unidadesDefensa;
    }

    // Métodos
    public void iniciarJuego() {
        System.out.println(" ************************** El Juego comenzó!! ************************** ");
        System.out.println(
                "Listado de naves y flotas registradas: \n" + this.unidadesDefensa + "\n");
        System.out.println("listado de posiciones de los asteroides: \n" + this.asteroides + "\n");
        System.out.println(" .:..::..:::.:.:.. Que ganen los mejores! .:..::..:::.:.:..\n");
    }

    public void calcularGanadores(List<Asteroide> asteroides, List<IUnidadDefensa> unidadesDefensa) {
        IUnidadDefensa unidadDefensaGanadora = null;
        for (Asteroide asteroide : asteroides) {
            Double distancia = 0.0;
            IUnidadDefensa unidadGanadoraAsteroide = null;

            for (IUnidadDefensa unidad : unidadesDefensa) {
                if (unidadGanadoraAsteroide == null
                        || unidad.calcularDistancia(asteroide.getPuntoEspacio()) <= distancia) {
                    distancia = unidad.calcularDistancia(asteroide.getPuntoEspacio());
                    unidadGanadoraAsteroide = unidad;
                }
            }
            unidadGanadoraAsteroide.addPuntaje();
            System.out.println("La distancia más cercana a este asteroide es " + distancia);
            System.out.println("La nave más cercana fue " + unidadGanadoraAsteroide);
        }
        for (IUnidadDefensa iUnidadDefensa : unidadesDefensa) {
            if(unidadDefensaGanadora == null ||
                    unidadDefensaGanadora.getPuntaje() < iUnidadDefensa.getPuntaje()){
                unidadDefensaGanadora = iUnidadDefensa;
            }
        }
        System.out.println("La nave ganadora es .:::...:.:::.:::....:. " + unidadDefensaGanadora);
    }
}
