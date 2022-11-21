package com.company;

import java.util.Comparator;
import java.util.List;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;




    public void darDeAltaAuto(Auto auto){

        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(auto);
        }

    };
    public void darDeAltaMoto(Moto moto){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(moto);
        }

    };


    public void eliminarVehiculo(Vehiculo vehiculo){

    listaDeVehiculos.remove(vehiculo);

    };
    public void eliminarVehiculoConPatente(String patente){

        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));

    };


    public Vehiculo ganador(){

        return listaDeVehiculos.stream()
                .max(Comparator.comparingDouble
                        (v -> v.getVelocidad()* 0.5d * v.getAceleracion()/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100))))
                .get();

    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .get();
        socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente){

        Vehiculo vehiculo = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .get();
        socorristaMoto.socorrer((Moto) vehiculo);

    }


}
