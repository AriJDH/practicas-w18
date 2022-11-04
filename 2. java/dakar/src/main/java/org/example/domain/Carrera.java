package org.example.domain;

import lombok.Data;

import java.util.*;

public @Data class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(vehiculos.size()<cantidadVehiculosPermitidos)
            vehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(vehiculos.size()<cantidadVehiculosPermitidos)
            vehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculo(String patente){
        Optional<Vehiculo> optV = encontrarVehiculoPorPatente(patente);
        if(optV.isPresent())
            vehiculos.remove(optV.get());
    }

    public Vehiculo getGanador(){
        return vehiculos.stream().max(Comparator.comparing(Vehiculo::getPuntaje))
                .orElseThrow(NoSuchElementException::new);
    }

    public Optional<Vehiculo> encontrarVehiculoPorPatente(String patente){
        return vehiculos.stream().filter(ve->ve.getPatente().equals(patente)).findFirst();
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> optV = encontrarVehiculoPorPatente(patente);
        if(optV.isPresent() && optV.get() instanceof Auto){
            socorristaAuto.socorrerAuto((Auto)optV.get());
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> optV = encontrarVehiculoPorPatente(patente);
        if(optV.isPresent() && optV.get() instanceof Moto){
            socorristaMoto.socorrerMoto((Moto)optV.get());
        }
    }
}
