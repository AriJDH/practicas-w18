package EjIntegradorVivo.Clases;

public class Hotel extends Reserva{
    private String nombre;

    public Hotel(String nombre, double montoAPagar) {
        super(montoAPagar);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", monto a pagar='" + getMontoAPagar() + '\'' +
                '}';
    }
}
