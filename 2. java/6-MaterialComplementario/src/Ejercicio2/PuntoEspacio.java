package Ejercicio2;

public class PuntoEspacio {

    // Atributos
    private Double coordenadaX;
    private Double coordenadaY;

    // Constructores
    public PuntoEspacio(Double coordenadaX, Double coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    // Getters
    public Double getCoordenadaX() {
        return coordenadaX;
    }

    public Double getCoordenadaY() {
        return coordenadaY;
    }

    // Métodos
    Double calcularDistancia(PuntoEspacio puntoEspacio){
        return Math.sqrt(
                Math.pow(this.coordenadaX -  puntoEspacio.getCoordenadaX(), 2)
                + Math.pow(this.coordenadaY - puntoEspacio.getCoordenadaY(), 2));
    }

    @Override
    public String toString() {
        return "\n " +
                "coordenadaX: " + coordenadaX +
                ", coordenadaY: " + coordenadaY;
    }
}
