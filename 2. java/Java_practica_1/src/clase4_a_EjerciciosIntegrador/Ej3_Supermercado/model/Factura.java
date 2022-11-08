package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model;

import java.util.List;

public class Factura {

    private String codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private double totalCompra;

    public Factura(String codigo, Cliente cliente, List<Item> listaItems) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = calcularTotalCompra();
    }

    @Override
    public String toString() {
        return "Factura --->" +
                "codigo='" + codigo + '\'' +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", totalCompra=" + totalCompra;
    }

    private double calcularTotalCompra(){
        return listaItems.stream().mapToDouble(x->x.getPrecioUnitario()*x.getCantComprada()).sum();
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public String getCodigo() {
        return codigo;
    }
}
