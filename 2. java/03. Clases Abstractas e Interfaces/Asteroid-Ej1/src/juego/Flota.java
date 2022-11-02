package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flota implements AtackUnit{
    private List<Nave> flota = new ArrayList<>();

    public void agregarNave(Nave nave){
        this.flota.add(nave);
    }

    @Override
    public double calcularDistancia(Coordenada blanco) {
        int tamanioFlota = flota.size();
        double distanciaPromedio = (flota.stream().map(n->n.calcularDistancia(blanco)).reduce(0.0,(a,b)->a+b))/tamanioFlota;
        return distanciaPromedio;
    }

    @Override
    public String toString() {
        return "Flota[" +
                flota.stream().map((nave)->nave.toString()).collect(Collectors.joining("\n\t\t")) +
                ']';
    }
}
