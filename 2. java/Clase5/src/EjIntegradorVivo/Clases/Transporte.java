package EjIntegradorVivo.Clases;

public class Transporte extends Reserva{
    private String destino;

    public Transporte(String destino, double montoAPagar) {
        super(montoAPagar);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "destino='" + destino + '\'' +
                ", monto a pagar='" + getMontoAPagar() + '\'' +
                '}';
    }
}
