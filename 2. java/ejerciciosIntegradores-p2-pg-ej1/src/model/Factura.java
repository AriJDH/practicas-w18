package model;

import java.util.Collections;
import java.util.List;

public class Factura {
    private int codigo;
    private Cliente cliente;
    private List<Item> itemList;
    private Double totalCompra;

    public Factura(int codigo, Cliente cliente, List<Item> itemList) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.itemList = itemList;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Double getTotalCompra() {
        return itemList.stream().
                map(item -> item.getCantidadComprada() * item.getCostoUnitario()).
                reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente.toString() +
                ", itemList=" + itemList +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
