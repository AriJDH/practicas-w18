package org.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class Factura {
    @EqualsAndHashCode.Include
    private Cliente cliente;
    @EqualsAndHashCode.Include
    private List<ItemCompra> items;
    @EqualsAndHashCode.Include
    private double totalCompra;


    public Factura(Cliente cliente, List<ItemCompra> items) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = items.stream().mapToDouble(item->item.getCostoUnitario()*item.getCantidad()).sum();
    }

    @Override
    public String toString(){
        String s = "Descripción de factura: \n\tCliente: \n\t\t" + cliente.toString() +
                "\n\tItems: ";
        for(ItemCompra item: items){
            s += "\n\t\t-" + item.toString();
        }
        s+= "\n\tTotal de compra: "+ this.totalCompra;
        return s;
    }

}
