import java.util.List;

public class Defensa {

    Flota flota;
    Nave nave;

    List<Double> historialDistancia;

    @Override
    public String toString() {
        return "Defensa{" +
                "flota=" + flota +
                ", nave=" + nave +
                ", historialDistancias=" + historialDistancias +
                '}';
    }

    public Flota getFlota() {
        return flota;
    }

    public void setFlota(Flota flota) {
        this.flota = flota;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public List<Double> getHistorialDistancias() {
        return historialDistancias;
    }

    public void setHistorialDistancias(List<Double> historialDistancias) {
        this.historialDistancias = historialDistancias;
    }

    public Defensa(Flota flota, Nave nave, List<Double> historialDistancias) {
        this.flota = flota;
        this.nave = nave;
        this.historialDistancias = historialDistancias;
    }

    List<Double> historialDistancias;

    public Defensa(){}
    public Defensa(List<Double> historialDistancias) {
        this.historialDistancias = historialDistancias;
    }


}
