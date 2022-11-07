package Models;

import Models.Cliente;
import Models.Paquete.Paquete;
import java.util.Arrays;
import java.util.List;
public class Localizador  {

    private Cliente cliente;
    private Double total;
    private List<Paquete> reservas;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void addReserva(Paquete paquete) {
        reservas.add(paquete);
    }

    public void addReserva(Paquete ...paquete){
        reservas.addAll(Arrays.asList(paquete));
    }
}
