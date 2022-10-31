package clase3_b_EjerComplementarios.Ej2;

import java.util.ArrayList;

public class Flota implements Navegable{
    private ArrayList<Nave> flota;

    public void addNave(Nave nave){
        flota.add(nave);
    }

    public Flota() {
        this.flota = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "Flota{" +
                "flota=" + flota +
                '}';
    }

    @Override
    public double getDistancia(int x, int y) {
        double distancia = 0;
        for ( Nave nave : flota ){
            distancia += nave.getDistancia(x,y);
        }
        return distancia / flota.size();
    }
}
