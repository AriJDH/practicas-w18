package InterfacesYClaseAbstractas.juego.clases;

import InterfacesYClaseAbstractas.juego.interfaces.Calculable;
import InterfacesYClaseAbstractas.juego.interfaces.Creable;
import InterfacesYClaseAbstractas.juego.interfaces.Mostrable;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Mostrable {

    private String nombre;
    private int puntaje;
    private UnidadDeDefensa defensa;
    List<Double> distanciasGanadoras = new ArrayList<>();

    public Jugador() {
        this.nombre = Creable.crearNombreJugador();
        int unidad = (int) Math.floor(Math.random() * 2);
        System.out.println(unidad);
        if (unidad == 0) {
            this.defensa = new NaveSimple();
        } else {
            this.defensa = new FlotaDeNaves();
        }
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public List<Double> getDistanciasGanadoras() {
        return distanciasGanadoras;
    }

    public void setPuntaje() {
        this.puntaje = getPuntaje() + 1;
    }

    public void setDistanciasGanadoras(double distanciasGanadora) {
        this.distanciasGanadoras.add(distanciasGanadora);
    }

    public UnidadDeDefensa getDefensa() {
        System.out.println();
        return defensa;
    }

    @Override
    public void mostrar() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return  "nombre..:" + getNombre() + '\n' +
                "puntaje..:" + getPuntaje() + '\n' +
                "defensa..:" + getDefensa() + '\n' +
                "distancias ganadoras..:" + getDistanciasGanadoras();
    }

}
