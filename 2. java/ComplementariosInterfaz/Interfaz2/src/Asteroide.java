public class Asteroide {
    Coordenada coordenadas;

    public Asteroide(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Asteroide{" +
                "coordenadas=" + coordenadas +
                '}';
    }
}
