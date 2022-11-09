package AgenciaDeTurismo.Clases;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, Double total, List<Reserva> reservas) {
        setCliente(cliente);
        setTotal(total);
        setReservas(reservas);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", total=" + total +
                ", reservas=" + reservas +
                '}';
    }
}
