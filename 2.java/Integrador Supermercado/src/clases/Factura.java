package clases;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> items;
    private double totalCompras;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

}
