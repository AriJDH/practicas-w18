package com.meli.lgutierrez.clase4.tarde.ejercicioIntegrador.model;

import java.util.List;

public class Factura {

    private Integer codigo;
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;

    public Factura() {
    }

    public Factura(Integer codigo, Cliente cliente, List<Item> items, Double totalCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
