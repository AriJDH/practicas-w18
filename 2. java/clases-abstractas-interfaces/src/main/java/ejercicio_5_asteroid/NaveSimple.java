package ejercicio_5_asteroid;

import java.awt.*;

public class NaveSimple implements Nave {
    String name;
    Point ubicacion;
    double puntuacion = 0;

    public NaveSimple(String name, Point ubicacion) {
        this.name = name;
        this.ubicacion = ubicacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public void calcularDistanciaAsteroide(Asteroide asteroide) {

    }
}
