package EjIntegradorVivo.Clases;

public class Reserva {
    private double montoAPagar;

    public Reserva(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }

    public double getMontoAPagar() {
        return montoAPagar;
    }

    public Reserva getReserva(){
        return this;
    }

    public void setMontoAPagar(double montoAPagar) {
        this.montoAPagar = montoAPagar;
    }
}
