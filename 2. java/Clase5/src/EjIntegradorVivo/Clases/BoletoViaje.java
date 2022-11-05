package EjIntegradorVivo.Clases;

public class BoletoViaje extends Reserva{
    private String destino;

    public BoletoViaje(String destino, double montoAPagar) {
        super(montoAPagar);
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "destino='" + destino + '\'' +
                ", monto a pagar='" + getMontoAPagar() + '\'' +
                '}';
    }
}
