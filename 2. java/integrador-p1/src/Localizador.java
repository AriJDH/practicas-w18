import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {

        this.total = calculaTotal(reservas);
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public double calculaTotal(List<Reserva> reservas){
        double total = reservas.stream().mapToDouble(x -> x.getCosto()).sum();
        return total;
    }


    public void agregaReserva(Reserva reserva){
        reservas.add(reserva);
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "\n cliente=" + cliente +
                "\n, reservas=" + reservas +
                "\n, total=" + total +
                '}';
    }
}
