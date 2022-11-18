package supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private Double total;

    public Factura(Cliente cliente, List<Item> listaItems, Double total) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
