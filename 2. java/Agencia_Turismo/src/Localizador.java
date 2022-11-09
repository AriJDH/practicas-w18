import java.util.ArrayList;

public class Localizador {

    private Cliente cliente;
    private ArrayList<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    private  void calcularTotal(){
        this.total = reservas.stream()
                    .map( res -> res.getPrecio()*res.getCantidad())
                    .reduce(0d,Double::sum);
    }


    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }
}


