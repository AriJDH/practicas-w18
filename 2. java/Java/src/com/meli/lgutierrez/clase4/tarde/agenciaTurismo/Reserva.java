package com.meli.lgutierrez.clase4.tarde.agenciaTurismo;

public class Reserva {

    private boolean hotel;
    private boolean vuelo;
    private boolean comida;
    private boolean transporte;
    private double precio;

    public Reserva(boolean hotel, boolean vuelo, boolean comida, boolean transporte, double precio) {
        this.hotel = hotel;
        this.vuelo = vuelo;
        this.comida = comida;
        this.transporte = transporte;
        this.precio = precio;
    }

    public double precioReserva(){
        if (this.hotel == true && this.comida == true && this.transporte == true && this.vuelo == true){
            return this.precio*0.9;
        }
        return this.precio;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isVuelo() {
        return vuelo;
    }

    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + hotel +
                ", vuelo=" + vuelo +
                ", comida=" + comida +
                ", transporte=" + transporte +
                ", precio=" + precio +
                '}';
    }
}
