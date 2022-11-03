public class ReservaComida extends Reserva{
    public ReservaComida(String nombre, double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "\n ReservaComida " + super.getNombre() +" costo: "+super.getCosto();
    }
}
