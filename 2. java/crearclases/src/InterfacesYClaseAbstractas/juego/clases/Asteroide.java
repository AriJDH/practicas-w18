package InterfacesYClaseAbstractas.juego.clases;

import InterfacesYClaseAbstractas.juego.interfaces.Creable;
import InterfacesYClaseAbstractas.juego.interfaces.Mostrable;

public class Asteroide implements Mostrable {

    private double x;
    private double y;

    public Asteroide() {
        this.x = Creable.crearCoordenada();
        this.y = Creable.crearCoordenada();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void mostrar() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Coordenada x..:" + x + '\n' +
                "Coordenada y..:" + y + '\n';
    }
}
