package com.meli.domain;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nPrecio unitario: "+this.calcular(1);
    }

    public double calcular(int cantidad){
        return cantidad*this.precio;
    }

}
