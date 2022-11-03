package org.example.domain;

public class Vehiculo {
    private String modelo;
    private String marca;
    private double costo;

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.marca = marca;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString(){
        return "Marca: "+this.marca+". Modelo: "+this.modelo+". Costo: "+this.costo+".";
    }

    public static int compareCosto(Vehiculo v1, Vehiculo v2){
        if(v1.getCosto()>=v2.getCosto())
            return 1;
        else return -1;
    }

    public static int compareMarca(Vehiculo v1, Vehiculo v2){
        return v1.getMarca().compareTo(v2.getMarca());
    }
}
