public class ReservaTransporte extends Reserva{
    public ReservaTransporte(String nombre, double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "\nReservaTransporte " + super.getNombre() +" costo: "+super.getCosto();
    }
}
