package com.meli.lgutierrez.clase5.ejercicioPractico2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Carrera() {
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Optional<Vehiculo> encontrarVehiculoPorPatente(String patente){
        return vehiculos.stream().filter(v -> v.getPatente().equals(patente)).collect(Collectors.toList()).stream().findFirst();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if(this.vehiculos.size() < cantidadDeVehiculosPermitidos){
            Optional<Vehiculo> vehiculo = encontrarVehiculoPorPatente(patente);
            if (vehiculo.isEmpty()) {
                vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Se inscribió el vehículo " + patente + " exitosamente");
            } else {
                System.out.println("El auto ya se encuentra inscrito en la carrera");
            }
        } else {
            System.out.println("El cupo llegó a su límite, el auto no puede participar");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if(this.vehiculos.size() < cantidadDeVehiculosPermitidos){
            Optional<Vehiculo> vehiculo = encontrarVehiculoPorPatente(patente);
            if (vehiculo.isEmpty()) {
                vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
                System.out.println("Se inscribió el vehículo " + patente + " exitosamente");
            } else {
                System.out.println("La moto ya se encuentra inscrito en la carrera");
            }
        } else {
            System.out.println("El cupo llegó a su límite, la moto no puede participar");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (vehiculos.contains(vehiculo)){
            vehiculos.remove(vehiculo);
            System.out.println("Vehiculo eliminado exitosamente");
        }else {
            System.out.println("Vehiculo no encontrado");
        }

    }

    public void eliminarVehiculoConPatente(String patente){
        Optional<Vehiculo> vehiculo = encontrarVehiculoPorPatente(patente);
        if (vehiculo.isEmpty()){
            System.out.println("Vehiculo no encontrado");
        }else {
            vehiculos.remove(vehiculo.get());
            System.out.println("Vehiculo eliminado exitosamente");
        }
    }

    public Vehiculo determinarGanador(){

        Double puntaje = 0D;
        Vehiculo ganador = null;

        for (Vehiculo v : vehiculos) {
            Double puntajeV = (v.getVelocidad()*(1/2)*v.getAceleracion())/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));

            if (puntajeV > puntaje){
                ganador = v;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> auto = encontrarVehiculoPorPatente(patente);
        if (auto.isEmpty()){
            System.out.println("No se encontró el vehículo");
        } else {
            socorristaAuto.socorrer(auto.get());
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> moto = encontrarVehiculoPorPatente(patente);
        if (moto.isEmpty()){
            System.out.println("No se encontró el vehículo");
        } else {
            socorristaMoto.socorrer(moto.get());
        }
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
