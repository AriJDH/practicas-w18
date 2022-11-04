package org.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public @Data class ItemCompra {
    @EqualsAndHashCode.Include
    private String codigo;
    @EqualsAndHashCode.Include
    private String nombre;
    @EqualsAndHashCode.Include
    private int cantidad;
    @EqualsAndHashCode.Include
    private double costoUnitario;

    public ItemCompra(String codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString(){
        return "Codigo: "+ this.codigo +". Nombre: " + this.nombre
                + ". Cantidad: "+ this.cantidad + ". Costo Unitario: " + this.costoUnitario + ".";
    }
}
