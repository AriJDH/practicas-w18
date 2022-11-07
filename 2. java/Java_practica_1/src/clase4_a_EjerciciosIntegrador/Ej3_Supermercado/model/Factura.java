package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItems;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> listaItems) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = calcularTotalCompra();
    }

    private double calcularTotalCompra(){
        return listaItems.stream().mapToDouble(x->x.getPrecioUnitario()*x.getCantComprada()).sum();
    }

    public double getTotalCompra() {
        return totalCompra;
    }
}
