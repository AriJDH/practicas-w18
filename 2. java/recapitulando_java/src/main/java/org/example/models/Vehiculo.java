package org.example.models;

public class Vehiculo {

    private String marca;
    private String modelo;
    private Double costo;

    public Vehiculo() {
        //No-args constructor
    }

    public Vehiculo(String marca, String modelo, Double costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
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

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Marca: '" + marca + '\'' +
                ", Modelo = '" + modelo + '\'' +
                ", Costo = " + costo;
    }
}
