package InterfacesYClaseAbstractas.juego.clases;

import InterfacesYClaseAbstractas.juego.interfaces.Calculable;
import InterfacesYClaseAbstractas.juego.interfaces.Creable;
import InterfacesYClaseAbstractas.juego.interfaces.Mostrable;

import java.util.ArrayList;
import java.util.List;

public class FlotaDeNaves extends UnidadDeDefensa implements Mostrable {

    private List<NaveSimple> flota = new ArrayList<>();

    public FlotaDeNaves() {
        flota = Creable.crearFlota();
    }

    public List<NaveSimple> getFlota() {
        return flota;
    }

    @Override
    public void mostrar() {
        toString();
    }

    @Override
    public String toString() {
        return "\n" + flota + '\n';
    }

    @Override
    public Double calcularDistancia(Asteroide asteroide) {
        Double distancia = getFlota().stream()
           .map(nave ->
               nave.calcularDistancia(asteroide))
                .reduce(0.00,(acumulador, elemento)->
                            acumulador + elemento)/ getFlota().size();
            return distancia;
    }
}
