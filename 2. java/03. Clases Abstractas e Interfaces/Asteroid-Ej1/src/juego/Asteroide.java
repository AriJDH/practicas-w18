package juego;

public class Asteroide {
    private Coordenada coordenada;

    public Asteroide(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    @Override
    public String toString() {
        return "Asteroide[" + coordenada +
                ']';
    }

}
