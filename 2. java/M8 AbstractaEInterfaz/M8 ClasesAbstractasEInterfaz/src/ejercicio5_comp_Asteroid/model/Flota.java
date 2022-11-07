package ejercicio5_comp_Asteroid.model;

import java.util.List;

public class Flota implements INave{

    List<NaveSimple> flota;

    public Flota() {
    }

    public Flota(List<NaveSimple> flota) {
        this.flota = flota;
    }

    public List<NaveSimple> getFlota() {
        return flota;
    }

    public void setFlota(List<NaveSimple> flota) {
        this.flota = flota;
    }

    @Override
    public String toString() {
        return "Flota{" +
                "flota=" + flota +
                '}';
    }

    @Override
    public double calcularDistancia(List coordenadasAtaque) {
        double promedio;
        double distanciaTotal=0;

        for(INave nave : flota){
            distanciaTotal += nave.calcularDistancia(coordenadasAtaque);
        }
        promedio = distanciaTotal/flota.size();

        return promedio;
    }

    
    @Override
    public int calcularPuntaje() {
        
        int puntuacion = 0; 
        
        for (NaveSimple nave: flota) {
            puntuacion = nave.getPuntuacion();
            puntuacion+=1;
            nave.setPuntuacion(puntuacion);
        }

        return puntuacion;
    }
}
