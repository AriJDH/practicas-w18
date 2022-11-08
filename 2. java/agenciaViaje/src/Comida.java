public class Comida extends Reserva{
    public Comida(Double costo, String nombre) {
        super(costo, nombre);
    }

    @Override
    public String toString() {
        return "Comida{}" + getNombre() ;
    }
}
