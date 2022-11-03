package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class FlotaNaves implements IUnidadDefensa {

    // Atributos
    private List<NaveSimple> naves = new ArrayList<>();
    private Double puntaje;

    // Constructores
    public FlotaNaves(List<NaveSimple> naves, Double puntaje) {
        this.naves = naves;
        this.puntaje = puntaje;
    }

    public FlotaNaves() {

    }

    // Getters
    public List<NaveSimple> getNaves() {
        return naves;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    // Métodos
    @Override
    public void addPuntaje() {
        this.puntaje++;
    }

    public Double calcularDistancia(PuntoEspacio puntoEspacio) {
        List<Double> distanciasNaves = new ArrayList<>();
        for (NaveSimple nave : this.naves) {
            Double distanciaNave = nave.calcularDistancia(puntoEspacio);
            distanciasNaves.add(distanciaNave);
        }
        Double sumaDistancias = 0.0;
        for (Double distancia : distanciasNaves) {
            sumaDistancias += distancia;
        } return sumaDistancias / distanciasNaves.size();
    }

    @Override
    public String toString() {
        return "\n ---------- Flota de naves ----------   \n " +
                naves + "\n puntaje de la flota: " + puntaje + "\n --------------------------------- \n";
    }
}


