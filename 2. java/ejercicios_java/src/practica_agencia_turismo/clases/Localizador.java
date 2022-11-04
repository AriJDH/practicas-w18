package practica_agencia_turismo.clases;

import practica_agencia_turismo.interfaces.ILocalizador;

import java.util.ArrayList;
import java.util.List;

public class Localizador implements ILocalizador {

    private List<Reserva> reservas = new ArrayList<>();

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                '}';
    }
}
