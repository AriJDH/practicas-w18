package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje() {
        //No-args constructor
    }

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo> ();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculos(Vehiculo... vehiculos) {
        this.vehiculos.addAll(Arrays.asList(vehiculos));
    }

    public void vehiculosPorPrecioDescendente() {
        System.out.println("Lista de vehículos ordenados por precio de menor a mayor:\n");

        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void vehiculosPorMarcaYPrecio() {
        System.out.println("\nLista de vehículos ordenados por marca y por precio de menor a mayor:\n");

        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void vehiculosPrecioMenos1000() {
        System.out.println("\nLista de vehículos con precio no mayor a 1000:\n");

        vehiculos.stream()
                .filter(v -> v.getCosto() < 1000.)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void vehiculosPrecioMayorIgual1000() {
        System.out.println("\nLista de vehículos con precio mayor o igual a 1000:\n");

        vehiculos.stream()
                .filter(v -> v.getCosto() >= 1000.)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void promedioPreciosVehiculos() {
        Double promedio = vehiculos.stream()
                .mapToDouble(v -> v.getCosto())
                .average()
                .orElse(0);

        System.out.println("\nPromedio total del precio de los vehículos: $" + promedio);
    }
}
