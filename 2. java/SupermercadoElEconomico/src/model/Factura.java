package model;

import java.util.List;

public class Factura {

    private Long codigo;
    private Cliente cliente;
    private List<Item>listaItes;
    private double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Item> listaItes, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItes = listaItes;
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

    public List<Item> getListaItes() {
        return listaItes;
    }

    public void setListaItes(List<Item> listaItes) {
        this.listaItes = listaItes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
