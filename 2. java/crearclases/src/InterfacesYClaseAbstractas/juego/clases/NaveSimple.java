package InterfacesYClaseAbstractas.juego.clases;

import InterfacesYClaseAbstractas.juego.interfaces.Calculable;
import InterfacesYClaseAbstractas.juego.interfaces.Creable;
import InterfacesYClaseAbstractas.juego.interfaces.Mostrable;

import java.util.ArrayList;
import java.util.List;

public class NaveSimple extends UnidadDeDefensa implements Creable, Mostrable {

    private String nombre;
    private double x;
    private double y;

    public NaveSimple(String nombre, double x, double y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public NaveSimple() {
        this.nombre = Creable.crearNombre();
        this.x = Creable.crearCoordenada();
        this.y = Creable.crearCoordenada();
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public void mostrar() {
        toString();
    }

    @Override
    public String toString() {
        return "nombre de la nave..:" + getNombre() + '\n' +
                "Coordenada X..:" + getX() + '\n' +
                "Coordenada Y..:" + getY() + '\n' ;
    }

    @Override
    public Double calcularDistancia(Asteroide asteroide) {
        Double distancia = Math.hypot(asteroide.getX() - getX(), asteroide.getY() - getY() );
        return distancia;
    }
}
