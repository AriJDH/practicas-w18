package classes;

import java.util.List;

public class Factura {
    private Double total;
    private List<Item> listaDeItems;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public Factura(Double total, List<Item> listaDeItems) {
        this.total = total;
        this.listaDeItems = listaDeItems;
    }
}
