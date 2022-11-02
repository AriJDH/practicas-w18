package Ejercicio2;

import java.util.List;

public class Flota implements Component{

   private List<Component> flota;


    public Flota(List<Component> flota) {
        this.flota = flota;
    }

    public Flota(){

    }

    public List<Component> getFlota() {
        return flota;
    }

    public void setFlota(List<Component> flota) {
        this.flota = flota;
    }

    @Override
    public double calcularPuntos(int x, int y) {

        return 0;
    }

    @Override
    public void addNave(Component nave) {
        flota.add(nave);
    }

}
