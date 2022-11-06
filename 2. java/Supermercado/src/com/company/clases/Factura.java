package com.company.clases;

import java.util.ArrayList;
import java.util.List;

public class Factura{
    private Long codigo;
    private Cliente cliente; //relación
    private List <Item> productos;
    private Double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Item> productos, Double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.productos = productos;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getProductos() {
        return productos;
    }

    public void setProductos(List<Item> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
