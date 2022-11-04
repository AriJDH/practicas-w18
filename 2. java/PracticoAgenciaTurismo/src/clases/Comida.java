package clases;

public class Comida extends Reserva{
    public Comida(String nombre, double costo, int cantidad) {
        super(nombre, costo, cantidad);
    }

    @Override
    public String toString() {
        return "Comida " + super.toString();
    }
}
