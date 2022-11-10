package Clases;

import Interfaces.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorBase implements Localizador {
    private String idCliente;
    private double total;
    private List<String> reservas= new ArrayList<String>();

    public LocalizadorBase(String idCliente, double total, List<String> reservas) {
        this.idCliente = idCliente;
        this.total = total;
        this.reservas = reservas;
    }

    @Override
    public double getTotal() {
        return this.total;
    }

    @Override
    public List<String> getReservas() {
        return this.reservas;
    }
}
