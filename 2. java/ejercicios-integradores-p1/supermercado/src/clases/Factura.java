package clases;

import java.util.List;

public class Factura {
    private String id;
    private double totalCompras;
    private Cliente cliente;
    List<Producto> productos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Factura() {}

    public Factura(String id, double totalCompras, Cliente cliente, List<Producto> productos) {
        this.id = id;
        this.totalCompras = totalCompras;
        this.cliente = cliente;
        this.productos = productos;
    }
}

