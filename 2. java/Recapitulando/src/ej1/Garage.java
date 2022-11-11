package ej1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> listaDeVehiculos;

    public Garage(int id, ArrayList<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public void ordenarAsc(){
        List<Vehiculo> list = listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    public void ordenarAsc2(){
        List<Vehiculo> list = listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    public void menoresA1k(){
        List<Vehiculo> list = listaDeVehiculos.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    public void mayoresA1k(){
        List<Vehiculo> list = listaDeVehiculos.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }

    public void statistics(){
        List<Vehiculo> list = listaDeVehiculos.stream()
                .
    }
}
