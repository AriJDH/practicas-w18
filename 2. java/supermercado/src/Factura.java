import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items, double totalCompra) {
        this.cliente = cliente;
        this.totalCompra = totalCompra;
        this.items = new ArrayList();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
