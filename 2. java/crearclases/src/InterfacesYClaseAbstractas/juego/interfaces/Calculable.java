package InterfacesYClaseAbstractas.juego.interfaces;

import InterfacesYClaseAbstractas.juego.clases.Asteroide;

public interface Calculable {

    public Double calcularDistancia(Asteroide asteroide);
}

   /* public Double calcularDistancia(Asteroide asteroide) {
        Double distancia = getFlota().stream()
                .map(nave ->
                        nave.calcularDistancia(asteroide))
                .reduce(0.00,(acumulador, elemento)->
                        acumulador + elemento)/ getFlota().size();
        return distancia;
    }*/