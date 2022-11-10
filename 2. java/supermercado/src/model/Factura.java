package model;

import model.Cliente;

import java.util.List;

public class Factura {
    private String codigo;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(String codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream().mapToDouble(i -> i.getCostoTotal()).sum();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
