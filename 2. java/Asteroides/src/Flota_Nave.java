import java.util.ArrayList;

public class Flota_Nave implements Nave{

    ArrayList<Nave> naves = new ArrayList<>();
    int puntuacion;

    public Flota_Nave(ArrayList<Nave> naves) {
        this.naves = naves;
        this.puntuacion = 0;
    }

    @Override
    public double distancia(int x, int y) {
        double sum_dist = 0;
        double cont_naves = 0;
        for (Nave naves: naves){
            sum_dist += naves.distancia(x,y);
            cont_naves =+ 1;
        }
        return sum_dist/cont_naves;
    }

    public int getPuntuacion() {

        return this.puntuacion;

    }

    public void setPuntuacion() {
        this.puntuacion += 1;
    }

    @Override
    public String toString() {
        return "Flota_Nave{" +
                "naves=" + naves +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
