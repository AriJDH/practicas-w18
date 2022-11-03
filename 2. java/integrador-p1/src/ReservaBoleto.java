public class ReservaBoleto extends Reserva{
    public ReservaBoleto(String nombre, double costo) {
        super(nombre, costo);
    }

    @Override
    public String toString() {
        return "\nReservaBoleto "+ super.getNombre() +" costo: "+super.getCosto();
    }
}
