package Lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo ford1 = new Vehiculo("Fiesta", "Ford", 1000.);
        Vehiculo ford2 = new Vehiculo("Focus", "Ford", 1200.);
        Vehiculo ford3 = new Vehiculo("Explorer", "Ford", 2500.);
        Vehiculo fiat1 = new Vehiculo("Uno", "Fiat", 500.);
        Vehiculo fiat2 = new Vehiculo("Cronos", "Fiat", 1000.);
        Vehiculo fiat3 = new Vehiculo("Torino", "Fiat", 1250.);
        Vehiculo chevrolet1 = new Vehiculo("Aveo", "Chevrolet", 1250.);
        Vehiculo chevrolet2 = new Vehiculo("Spin", "Chevrolet", 2500.);
        Vehiculo toyota1 = new Vehiculo("Corolla", "Toyota", 1200.);
        Vehiculo toyota2 = new Vehiculo("Fortuner", "Toyota", 3000.);
        Vehiculo renault = new Vehiculo("Logan", "Renault", 950.);
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(ford1);
        vehiculos.add(ford2);
        vehiculos.add(ford3);
        vehiculos.add(fiat1);
        vehiculos.add(fiat2);
        vehiculos.add(fiat3);
        vehiculos.add(chevrolet1);
        vehiculos.add(chevrolet2);
        vehiculos.add(toyota1);
        vehiculos.add(toyota2);
        vehiculos.add(renault);
        vehiculos.stream().sorted((v1, v2) -> Double.compare(v2.getCosto(), v1.getCosto())).forEach(System.out::println);
        System.out.println("-------------");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("-------------");
        vehiculos.stream().filter(v1 -> v1.getCosto() < 1000).forEach(System.out::println);
        System.out.println("-------------");
        vehiculos.stream().filter(v1 -> v1.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(Math.round(vehiculos.stream().mapToDouble(v1 -> v1.getCosto()).average().orElse(0)));
    }
}
