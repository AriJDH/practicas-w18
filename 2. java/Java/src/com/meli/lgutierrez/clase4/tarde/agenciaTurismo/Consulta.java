package com.meli.lgutierrez.clase4.tarde.agenciaTurismo;

import java.util.*;
import java.util.stream.Collectors;

public class Consulta {
    private List<Cliente> clientes;

    public Consulta() {
        this.clientes = new ArrayList<>();
    }

    public int consultarLocalizadores(){
        int localizadores = 0;
        for (Cliente cliente : clientes) {
            localizadores += cliente.getLocalizadores().size();
        }
        return localizadores;
    }

    public int consultarReservas(){
        int reservas = 0;
        for (Cliente cliente : clientes) {
            reservas += cliente.getLocalizadores().stream().map(m -> m.getReservas().size()).collect(Collectors.toList()).stream().reduce(0, (a, b) -> a+b);
        }

        return reservas;
    }

    public Map<String, List<Reserva>> clasificacionReservas(){
        Map<String, List<Reserva>> tipoReservas = new HashMap<>();
        List<Reserva> hoteles = new ArrayList<>();
        List<Reserva> vuelos = new ArrayList<>();
        List<Reserva> comidas = new ArrayList<>();
        List<Reserva> transportes = new ArrayList<>();


        for (Cliente cliente : clientes) {
            for (Localizador localizador : cliente.getLocalizadores()){
                for (Reserva reserva : localizador.getReservas()){
                    if (reserva.isHotel()){
                        hoteles.add(reserva);
                    }
                    if (reserva.isVuelo()){
                        vuelos.add(reserva);
                    }
                    if (reserva.isComida()){
                        comidas.add(reserva);
                    }
                    if (reserva.isTransporte()){
                        transportes.add(reserva);
                    }
                }
            }
        }

        tipoReservas.put("Hoteles", hoteles);
        tipoReservas.put("Vuelos", vuelos);
        tipoReservas.put("Comidas", comidas);
        tipoReservas.put("Transportes", transportes);


        return  tipoReservas;
    }

    public double consultarVentas(){
        double ventas = 0;
        for (Cliente cliente : clientes) {
            ventas += cliente.getLocalizadores().stream().mapToDouble(l -> l.getFactura()).sum();
        }

        return ventas;
    }

    public double promedioVentas(){

        return consultarVentas()/consultarReservas();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
