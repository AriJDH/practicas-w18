import java.util.List;

public class Paquete extends Reservable{

    // Atributos
    private List<Reservable> reservables;


    // Métodos
    @Override
    public void calcularDescuento(Double descuento) {

    }

    @Override
    public Double calcularPrecio() {
        return null;
    }

    public void agregarReservable(Reservable reservable){
        reservables.add(reservable);
    }

    public List<Reservable> getReservables() {
        return reservables;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "reservables=" + reservables +
                ", precio=" + precio +
                ", descuentoAplicado=" + descuentoAplicado +
                '}';
    }
}
