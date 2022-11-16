package com.meli.lgutierrez.clase4.mañana;

public class Vehiculo {

    private String modelo;
    private String marca;
    private int precio;

    public Vehiculo(String marca, String modelo, int precio) {
        this.modelo = modelo;
        this.marca = marca;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vehiculo de marca " + this.marca + ", cuyo modelo es " + this.modelo + " tiene un precio de $" + this.precio;
    }
}
