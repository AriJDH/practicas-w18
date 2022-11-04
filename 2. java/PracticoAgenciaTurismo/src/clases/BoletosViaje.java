package clases;

public class BoletosViaje extends Reserva {


    public BoletosViaje(String nombre, double costo, int cantidad) {
        super(nombre, costo, cantidad);
    }

    @Override
    public String toString() {
        return "Viaje " + super.toString();
    }
}
