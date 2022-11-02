package juego;

public class Nave implements AtackUnit {
    private String nombre;
    private Coordenada coordenada;

    public Nave(String nombre, Coordenada coordenada) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    @Override
    public double calcularDistancia(Coordenada blanco) {
        return this.coordenada.calcularDistanciaA(blanco);
    }

    @Override
    public String toString() {
        return "Nave[" +
                "nombre:'" + nombre + '\'' +
                ", coordenada:" + coordenada +
                ']';
    }
}
