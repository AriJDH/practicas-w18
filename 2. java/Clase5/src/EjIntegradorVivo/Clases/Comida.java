package EjIntegradorVivo.Clases;

public class Comida extends Reserva{
    private String tipoDeComida;

    public Comida(String tipoDeComida, double montoAPagar) {
        super(montoAPagar);
        this.tipoDeComida = tipoDeComida;
    }

    public String getTipoDeComida() {
        return tipoDeComida;
    }

    public void setTipoDeComida(String tipoDeComida) {
        this.tipoDeComida = tipoDeComida;
    }

    @Override
    public String toString() {
        return "Comida{" +
                "tipoDeComida='" + tipoDeComida + '\'' +
                ", monto a pagar='" + getMontoAPagar() + '\'' +
                '}';
    }
}
