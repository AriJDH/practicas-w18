package meli.bootcamp.clases;

import java.util.ArrayList;

public class Factura {
    private Cliente cliente;
    private ArrayList<DetalleFactura> detalle;
    private double totalCompra;

    public Factura(Cliente cliente, double totalCompra) {
        this.cliente = cliente;
        detalle = new ArrayList<>();
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Factura{");
        sb.append("cliente=").append(cliente);
        sb.append(", detalle=").append(detalle);
        sb.append(", totalCompra=").append(totalCompra);
        sb.append('}');
        return sb.toString();
    }
}
