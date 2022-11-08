package model;

import java.util.List;

public class Factura {

    // Atributos
    private Long coodigo;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    // Constructores
    public Factura() {
    }

    public Factura(Long coodigo,
                   Cliente cliente,
                   List<Item> items,
                   Double total) {
        this.coodigo = coodigo;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    // Getters y setters


    public Long getCoodigo() {
        return coodigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }


    // Métodos

    private void calcularTotal(){
        total =  0.0;
        for (Item item : items) {
            total = total + item.getCantidad()*item.getCosto();
        }
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
