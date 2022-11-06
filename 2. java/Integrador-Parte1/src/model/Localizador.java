package model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private List<Paquete> reservas;

    public Localizador(Cliente cliente, Double total, List<Paquete> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
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

    public List<Paquete> getReservas() {
        return reservas;
    }

    public void setReservas(List<Paquete> reservas) {
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
