package meli.bootcamp.clases;

import meli.bootcamp.repositories.RepositorioLocalizador;

import java.util.ArrayList;

public class Localizador {
    private ArrayList<Reserva> reservas;
    private RepositorioLocalizador repositorioLocalizador;
    private double precio;

    public Localizador(double precio) {
        this.reservas = new ArrayList<>();
        this.precio = precio;
    }

    public RepositorioLocalizador getRepositorioLocalizador() {
        return repositorioLocalizador;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean tieneAlgunPaqueteCompleto()
    {
        for (Reserva r :
                reservas) {
            if (r.isViaje() && r.isTransp() && r.isHotel() && r.isComida())
            {
                return true;
            }
        }
        return false;
    }

    public boolean tieneDobleHotelViaje()
    {
        int ctdHotel, ctdViaje;
        ctdHotel = 0;
        ctdViaje = 0;

        for (Reserva r :
                reservas) {
            if (r.isComida())
            {
                ctdHotel++;
            }
            if (r.isViaje())
            {
                ctdViaje++;
            }
            if (ctdHotel >= 2 || ctdViaje >= 2)
            {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Reserva> getReserva(){
        return reservas;
    }

    public void agregarReserva(Reserva r){
        reservas.add(r);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Localizador{");
        sb.append("reservas=").append(reservas);
        sb.append('}');
        return sb.toString();
    }

    public void mostrarReservas() {
        for (Reserva r :
                reservas) {
            System.out.println(r);
        }
    }
}
