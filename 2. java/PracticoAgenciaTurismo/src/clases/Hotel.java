package clases;

public class Hotel extends Reserva{
    public Hotel(String nombre, double costo, int cantidad) {
        super(nombre, costo, cantidad);
    }

    @Override
    public String toString() {
        return "Hotel " + super.toString();
    }
}
