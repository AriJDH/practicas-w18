package practica_complementario_clase_abstracta.ejercicio2;

import java.util.List;

public class Participante {

    private List<Asteroide> coordenadasAsteroides;

    private ContenedorNaves contenedorNaves = new ContenedorNaves();

    public List<Asteroide> getCoordenadasAsteroides() {
        return coordenadasAsteroides;
    }

    public void setCoordenadasAsteroides(List<Asteroide> coordenadasAsteroides) {
        this.coordenadasAsteroides = coordenadasAsteroides;
    }

    public ContenedorNaves getContenedorNaves() {
        return contenedorNaves;
    }

    public void setContenedorNaves(ContenedorNaves contenedorNaves) {
        this.contenedorNaves = contenedorNaves;
    }

    public void cargarNaves(INave... naves) {
        contenedorNaves.add(naves);
    }

    public double empezarJuego() {

        double puntuacionMayor = 0;

        for (Asteroide asteroide: this.coordenadasAsteroides) {

            double puntuacion = contenedorNaves.acumularPuntos(asteroide.getX(), asteroide.getY());

            if (puntuacion > puntuacionMayor) {
                puntuacionMayor = puntuacion;
            }
        }

        return puntuacionMayor;
    }
}
