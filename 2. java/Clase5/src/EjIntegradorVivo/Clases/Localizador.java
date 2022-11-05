package EjIntegradorVivo.Clases;
import EjIntegradorVivo.IClienteRepositorio.IRepositorio;
import EjIntegradorVivo.Repositorio.RepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Long clienteId;
    private List<Reserva> listaDeReservas;
    private Long id;
    private double totalCompra;

    public Localizador(Long clienteId, List<Reserva> reserva) {
        this.clienteId = clienteId;
        this.listaDeReservas = reserva;
    }


    public Long getClienteId() {
        return clienteId;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<Reserva> getListaDeReservas() {
        return listaDeReservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void printLocalizador() {
        System.out.println("Localizador: " + "\n" +
                "cliente=" + this.clienteId + "\n" +
                "reservas=" + getListaDeReservas() + "\n" +
                "monto total a pagar=" + this.totalCompra);
    }

}
