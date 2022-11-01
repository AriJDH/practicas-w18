package practica_complementario_clase_abstracta.ejercicio2;

import java.util.List;

public class Participante {

    //private List<Asteroide> coordenadasAsteroides;

    private Integer puntuacion = 0;

    private ContenedorNaves contenedorNaves = new ContenedorNaves();

    /*public List<Asteroide> getCoordenadasAsteroides() {
        return coordenadasAsteroides;
    }

    public void setCoordenadasAsteroides(List<Asteroide> coordenadasAsteroides) {
        this.coordenadasAsteroides = coordenadasAsteroides;
    }*/

    public ContenedorNaves getContenedorNaves() {
        return contenedorNaves;
    }

    public void setContenedorNaves(ContenedorNaves contenedorNaves) {
        this.contenedorNaves = contenedorNaves;
    }

    public void cargarNaves(INave... naves) {
        contenedorNaves.add(naves);
    }

    public double empezarJuego(int x, int y) {

        double distanciaMasCercana = 0.0;

        for (int i = 0; i < contenedorNaves.getFlotaNaves().size(); i++) {

            INave nave = contenedorNaves.getFlotaNaves().get(i);

            double distancia = nave.calcularDistancia(x, y);

            if (i == 0) {
                distanciaMasCercana = distancia;
            }

            if (distancia < distanciaMasCercana) {
                distanciaMasCercana = distancia;
            }
        }

        return distanciaMasCercana;
    }

    public void sumarPunto() {
        this.puntuacion += 1;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "puntuacion=" + puntuacion +
                ", contenedorNaves=" + contenedorNaves +
                '}';
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }
}
