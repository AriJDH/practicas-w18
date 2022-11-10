package Clases;

import Interfaces.Localizador;

import java.util.List;

public class Hotel implements Localizador {
    protected Localizador localizador;

    public Hotel(Localizador localizador) {
        this.localizador = localizador;
    }

    @Override
    public double getTotal() {
        return localizador.getTotal()+10000;
    }

    @Override
    public List<String> getReservas() {
        String hotel="Hotel";
        return localizador.getReservas().add(hotel);
    }
}
