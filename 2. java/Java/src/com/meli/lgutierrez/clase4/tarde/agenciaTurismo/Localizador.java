package com.meli.lgutierrez.clase4.tarde.agenciaTurismo;

import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.repositorio.RepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private List<Reserva> reservas;
    private double factura;
    private RepositorioLocalizador rl;

    public Localizador() {
        this.reservas = new ArrayList<>();
        this.rl = new RepositorioLocalizador();
    }

    public void agregarReserva(Reserva reserva){
        rl.agregarReserva(this, reserva);
    }

    public double precioTotal(){
        int contadorVuelo = 0;
        int contadorHotel = 0;
        double precioReserva = 0;

        this.factura = 0;

        for (Reserva reserva: this.reservas) {
            this.factura += reserva.precioReserva();
        }

        if (reservas.size() == 2) {
            for (Reserva reserva : this.reservas) {
                if (reserva.isHotel() && reserva.isVuelo()) {
                    precioReserva += reserva.getPrecio();
                    contadorHotel++;
                    contadorVuelo++;
                } else {
                    if (reserva.isVuelo()) {
                        contadorVuelo++;
                        precioReserva += reserva.getPrecio();
                    }
                    if (reserva.isHotel()) {
                        contadorHotel++;
                        precioReserva += reserva.getPrecio();
                    }
                }
            }
        }
        if (contadorHotel == 2 || contadorVuelo == 2){
            this.factura -= (precioReserva*.05);
        }

        return this.factura;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getFactura() {
        return factura;
    }

    public void setFactura(double factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", Factura=" + precioTotal() +
                '}';
    }
}
