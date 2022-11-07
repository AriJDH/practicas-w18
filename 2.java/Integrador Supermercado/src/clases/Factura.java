package clases;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> items;
    private double totalCompras;

    public Factura(Cliente cliente, double totalCompras) {
        this.cliente = cliente;
        this.totalCompras = totalCompras;
        this.items = new ArrayList<>();
    }

}
