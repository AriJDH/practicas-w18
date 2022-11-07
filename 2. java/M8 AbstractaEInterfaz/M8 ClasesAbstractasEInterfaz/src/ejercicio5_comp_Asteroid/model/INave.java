package ejercicio5_comp_Asteroid.model;

import java.util.List;

public interface INave <T> {

    double calcularDistancia(List<T> coordenadasAtaque);

    int calcularPuntaje();


}