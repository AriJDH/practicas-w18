package com.meli.lgutierrez.clase4.mañana;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Sprin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fotuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garaje garaje = new Garaje(1, vehiculos);

        //Lista de vehiculos ordenadas de menor a mayor precio
        vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getPrecio)).forEach(System.out::println);

        System.out.println("----------------");

        //Lista ordenada por marca y precio
        vehiculos.stream().sorted(Comparator.comparingInt(Vehiculo::getPrecio)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);

        System.out.println("----------------");

        //Lista menor a 1000
        vehiculos.stream().filter(vehiculo -> vehiculo.getPrecio() < 1000).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------");

        //Lista mayor o igual a 1000
        vehiculos.stream().filter(vehiculo -> vehiculo.getPrecio() >= 1000).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------");

        //Promedio
        vehiculos.stream().mapToInt(Vehiculo::getPrecio).average().stream().forEach(System.out::println);

    }
}
