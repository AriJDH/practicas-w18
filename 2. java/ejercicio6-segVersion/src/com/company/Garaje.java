package com.company;

import java.util.*;

public class Garaje {
    private String id;
    private List <Vehiculo> vehiculoList;

    public Garaje() {
    }

    public Garaje(String id) {
        this.id = id;
        this.vehiculoList = new ArrayList<Vehiculo>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    //agregar varios elementro de uno solo
    public void agregarVehiculosLisado(Vehiculo... vehiculos) {
        for (Vehiculo v: vehiculos) {
            this.vehiculoList.add(v);
        }
    }

    //muestra de los vehiculos en orden precios ascendentes
    public void muestraVehiculosOrdenadosAscendente(){
        //vehiculoList.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach((x) -> System.out.println("Auto: "+x.getMarca() + " Costo: "+ x.getCosto()));
        vehiculoList.stream().sorted((x,y) -> x.getCosto().compareTo(y.getCosto())).forEach(System.out::println);
    }

    //muestra de los vehiculos en orden marca y precio
    public void muestraVehiculosOrdenadosMarcaPrecio(){
        vehiculoList.stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .sorted((x,y) -> x.getMarca().compareTo(y.getMarca()))
                .forEach(System.out::println);
    }

    //muestra de los vehiculos con precio mayor a 1000
    public void muestraVehiculosMayorIgual1000(){
        vehiculoList.stream().
                filter(v -> v.getCosto() >= 1000)
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);
    }

    //muestra del promedio de los vehiculos
    public void muestraPromedioVehiculos(){
        OptionalDouble totalCosto = vehiculoList.stream().mapToDouble(v -> v.getCosto()).average();
        System.out.println("Precio promedio: $" + totalCosto.getAsDouble());
    }
}
