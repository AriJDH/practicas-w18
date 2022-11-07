package ejercicio1.model;

import java.util.List;

public class Factura {

    private Double totalDeCompra;
    private Cliente cliente;
    private List<Item> itemList;


    public Factura(Double totalDeCompra, Cliente cliente, List<Item> itemList) {
        this.totalDeCompra = totalDeCompra;
        this.cliente = cliente;
        this.itemList = itemList;
    }


    public Double getTotalDeCompra() {
        return totalDeCompra;
    }

    public void setTotalDeCompra(Double totalDeCompra) {
        this.totalDeCompra = totalDeCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }


    @Override
    public String toString() {
        return "Factura{" +
                "totalDeCompra=" + totalDeCompra +
                ", cliente=" + cliente +
                ", itemList=" + itemList +
                '}';
    }

}
