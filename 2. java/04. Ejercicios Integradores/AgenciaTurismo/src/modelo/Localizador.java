package modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private static Long idLocalizadorGlobal = 0l;
    private Long id;
    private Cliente cliente;
    private Double total;
    private List<TipoReserva> reservas;

    public Localizador(Cliente cliente, List<TipoReserva> reservas) {
        this.id = ++idLocalizadorGlobal;
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = reservas.stream().mapToDouble(r->r.precio).sum();
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {
        return total;
    }

    public List<TipoReserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Localizador " + id +
                "=\n\t" + cliente +
                "\n\tTotal: $" + String.format("%.2f", total) +
                "\n\tReservas: " + reservas.stream().map(r->r.toString()).collect(Collectors.joining("\n"));
    }
}
