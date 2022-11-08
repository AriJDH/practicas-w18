import java.util.List;

public class Flota implements Idefensa {
    List<Nave> flota;

    @Override
    public String toString() {
        return "Flota{" +
                "flota=" + flota +
                '}';
    }

    public Flota(){}
    public Flota(List<Nave> flota) {
        this.flota = flota;
    }

    public List<Nave> getFlota() {
        return flota;
    }

    public void setFlota(List<Nave> flota) {
        this.flota = flota;
    }

    @Override
    public double calcularDistancia( Asteroide asteroide){
        double rta=0;
        for(Nave n: this.flota){
            rta +=n.calcularDistancia(asteroide);
        }
        return rta/this.flota.size();
    }
}
