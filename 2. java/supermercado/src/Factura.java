import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<String> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<String> items, double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
        this.items = new ArrayList();
    }

}
