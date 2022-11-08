package model;

import java.util.List;

public class Factura {
    private List<Reserva> reservas;
    private double total;

    public Factura(List<Reserva> reservas) {
        this.reservas = reservas;

    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }



    @Override
    public String toString() {
        return "Factura{" +
                "reservas=" + reservas +
                ", total=" + total +
                '}';
    }

    public double calcularTotalFactura(){
        double totalFactura=0.0;
        for (Reserva reserva :
                reservas) {
            totalFactura+= reserva.getPrecio();
        }
        return totalFactura;
    }
}
