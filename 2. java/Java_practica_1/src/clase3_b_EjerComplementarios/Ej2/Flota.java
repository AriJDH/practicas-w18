package clase3_b_EjerComplementarios.Ej2;

import java.util.ArrayList;
import java.util.List;

public class Flota implements INave {
    private List<INave> flota;
    private String nombre;
    private Integer puntuacion;

    public Flota(String nombre) {
        this.nombre = nombre;
        this.flota = new ArrayList<>();
        this.puntuacion = 0;
    }


    @Override
    public String toString() {
        return "Flota:" + flota;
    }

    @Override
    public void add(INave nave) {
        this.flota.add(nave);
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setPuntuacion() {
        this.puntuacion ++;
    }

    @Override
    public Integer getPuntaje() {
        return this.puntuacion;
    }

    @Override
    public double calcularDistancia(int x, int y) {
        double distancia = 0;
        for ( INave nave : flota ){
            distancia += nave.calcularDistancia(x,y);
        }
        return distancia / flota.size();
    }
}
