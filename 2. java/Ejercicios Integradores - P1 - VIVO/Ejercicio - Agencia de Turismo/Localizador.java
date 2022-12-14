import java.util.List;

public class Localizador {

    private double total;
    private List<String> reservas;

    public Cliente cliente;

    public Localizador() {

    }

    public Localizador(double total, List<String> reservas, Cliente cliente) {
        this.total = total;
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<String> getReservas() {
        return reservas;
    }

    public void setReservas(List<String> reservas) {
        this.reservas = reservas;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente(){
        return this.cliente;
    }




}
