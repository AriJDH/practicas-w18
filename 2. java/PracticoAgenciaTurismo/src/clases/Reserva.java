package clases;

public abstract class Reserva {
    private String nombre;
    private double costo;
    private int cantidad;

    public Reserva(String nombre, double costo, int cantidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Reserva: " + nombre +". Cantidad: " + cantidad + ". Costo: " + costo +". \n";
    }
}
