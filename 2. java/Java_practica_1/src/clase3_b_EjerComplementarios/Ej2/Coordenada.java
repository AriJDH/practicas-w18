package clase3_b_EjerComplementarios.Ej2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Coordenada {
    private int x;
    private int y;
    private List<Double> listResultados;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
        this.listResultados = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Double> getResultado() {
        return this.listResultados;
    }

    public void setResultado(Double resultado) {
        this.listResultados.add(resultado);
    }


    @Override
    public String toString() {
        return "Coordenada{" +
                "x=" + x +
                ", y=" + y +
                ", resultados=" + this.listResultados +
                '}';
    }
}
