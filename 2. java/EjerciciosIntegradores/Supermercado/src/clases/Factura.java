package clases;

import java.util.*;

public class Factura {

    private int numeroFactura;
    private Cliente cliente;
    private List<ItemsPorFactura> items = new ArrayList<>();
    private double total;

    public Factura(int numeroFactura, Cliente cliente, ItemsPorFactura itemsFactura) {
            this.numeroFactura = numeroFactura;
            this.cliente = cliente;
            this.items.add(itemsFactura);
            this.total = itemsFactura.getSubTotal();
    }

    public List<ItemsPorFactura> getItems() {
        return items;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setItems(Integer cantidad, Producto producto) {
        ItemsPorFactura item = new ItemsPorFactura(cantidad, producto);
        items.add(item);
        setTotal();
    }

    public void setTotal() {
        this.total = items.stream()
        .mapToDouble(ItemsPorFactura::getSubTotal)
                .sum();
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return  "numeroFactura='" + numeroFactura + '\n' +
                "cliente=" + cliente + '\n' +
                "items=" + items + '\n' +
                "total=" + total;
    }
}
