package Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private List<Item> listaItems = new ArrayList<>();
    private double totalCompra;
    private Cliente cliente;
    private Long idFactura;

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = calcularTotalCompra(listaItems);
    }

    public double calcularTotalCompra(List<Item> listaItems){
        double total = 0;
        for(Item it: listaItems){
            total = it.getPrecio();
        }
        return total;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra +
                ", idFactura=" + idFactura +
                '}';
    }
}
