package com.company;

import java.util.List;
import java.util.OptionalDouble;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    public Carrera() {
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void agregarVehiculosLista(Vehiculo... vehiculos) {
        for (Vehiculo v : vehiculos) {
            this.listaVehiculos.add(v);
        }
    }


    public void darDeAltaAuto(double velocidad,double aceleracion,int anguloDeGiro,String patente){
        Auto auto = new Auto();

        auto.setAceleracion(aceleracion);
        auto.setVelocidad(velocidad);
        auto.setAnguloDeGiro(anguloDeGiro);
        auto.setPatente(patente);
        //Datos fijos
        auto.setPeso(1000);
        auto.setRuedas(4);

        listaVehiculos.add(auto);
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,int anguloDeGiro,String patente){
        Moto moto = new Moto();

        moto.setAceleracion(aceleracion);
        moto.setVelocidad(velocidad);
        moto.setAnguloDeGiro(anguloDeGiro);
        moto.setPatente(patente);
        //Datos fijos
        moto.setPeso(300);
        moto.setRuedas(2);
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            listaVehiculos.remove(vehiculo);
        }
    }

    public void eliminarVehiculoConPatente(String patente){
        /*
        *  vehiculoList.stream().
                filter(v -> v.getCosto() >= 1000)
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);
        * */
        if(listaVehiculos.isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            listaVehiculos.stream().forEach(x -> {
                if(x.getPatente().equals(patente)){
                    listaVehiculos.remove(x);
                }});
           /* for (Vehiculo v:listaVehiculos) {
                if(v.getPatente().equals(patente)){
                    listaVehiculos.remove(v);
                    break;
                }
            }*/
        }
    }

    public void ganadorCarrera(List<Vehiculo> listaVehiculos){
        //OptionalDouble ganador = vehiculo.getVelocidad * 1/2*Acelracion(anguloDeGiro * (Peso-Cantidad de ruedas * 100))
    }
    SocorristaAuto scA = new SocorristaAuto();

}
