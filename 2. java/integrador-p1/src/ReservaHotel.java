public class ReservaHotel extends Reserva{
    public ReservaHotel(String nombre, double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "\nReservaHotel" + super.getNombre() +" costo: "+super.getCosto();
    }
}
