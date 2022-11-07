package Clases;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> listaProductos =new ArrayList<Producto>();
    private int total;

    //Constructor
    public Factura(Cliente cliente, List<Producto> listaProductos, int total) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.total = total;
    }

    //To string
    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaProductos=" + listaProductos +
                ", total=" + total +
                '}';
    }

    //Getters and setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
