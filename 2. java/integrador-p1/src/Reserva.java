public class Reserva {
    private String nombre;

    private double costo;

    public Reserva(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public String getNombre() {
        return nombre;
    }
}
