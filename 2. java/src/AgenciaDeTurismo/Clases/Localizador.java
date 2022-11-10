package AgenciaDeTurismo.Clases;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total = 0.00;
    private List<Reserva> reservas;
    private Long codigoLocalizador;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        setCliente(cliente);
        setReservas(reservas);
    }

    public Long getCodigoLocalizador() {
        return codigoLocalizador++;
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
        if (reservas.stream().filter(f ->f.isBoletos()).count()> 1
        || reservas.stream().filter(f ->f.isHotel()).count()> 1)
        {
            this.total = total - (total * (5/100));
        }else{
            this.total = total;
        }
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
