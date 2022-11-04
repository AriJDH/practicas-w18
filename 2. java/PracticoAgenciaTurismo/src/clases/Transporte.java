package clases;

public class Transporte extends Reserva{
    public Transporte(String nombre, double costo, int cantidad) {
        super(nombre, costo, cantidad);
    }

    @Override
    public String toString() {
        return "Transporte " + super.toString();
    }
}
