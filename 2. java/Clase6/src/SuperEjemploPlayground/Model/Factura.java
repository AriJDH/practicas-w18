package SuperEjemploPlayground.Model;
import Supermercado.Cliente;
import Supermercado.Item;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Long codigoFactura;
    private Cliente cliente;
    private List<Item> listaItems = new ArrayList<>();
    private double totalCompra;

    public Factura() {
    }

    public Factura(Long codigoFactura, Cliente cliente, List<Item> listaItems, double totalCompra) {
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = totalCompra;
    }

    public Long getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Long codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
