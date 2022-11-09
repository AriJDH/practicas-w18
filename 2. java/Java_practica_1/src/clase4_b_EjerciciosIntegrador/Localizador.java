package clase4_b_EjerciciosIntegrador;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double precio;
    private List<Reserva> reservaList;

    public Localizador(Cliente cliente, List<Reserva> reservaList) {
        this.cliente = cliente;
        this.precio = calcularPrecio();
        this.reservaList = reservaList;
    }

    private Double calcularPrecio(){
        return reservaList.stream().mapToDouble(x->x.getPrecio()).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
}
