package clases;

public abstract class Reserva {
    private double precio;

    public Reserva(double precio) {
        this.precio = precio;
    }

    public double getPrecio(){
        return this.precio;
    }
}
