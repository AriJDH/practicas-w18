package practica_recapitulando_java_vivo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));

        Garaje garaje = new Garaje(1L, vehiculos);

        //Ejercicio 3
        System.out.println("========= Vehiculos ordenados por costo menor a mayor =========");
        List<Vehiculo> vehiculosPorCosto = garaje.getVehiculos().stream().sorted((x, y) -> x.getCosto().compareTo(y.getCosto())).collect(Collectors.toList());
        vehiculosPorCosto.forEach(System.out::println);

        //Ejercicio 4
        System.out.println("\n");
        System.out.println("========= Vehiculos ordenados por marca y costo =========");
        List<Vehiculo> vehiculosMarcaCosto = garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto)).collect(Collectors.toList());

        vehiculosMarcaCosto.forEach(System.out::println);

        //Ejercicio 5
        System.out.println("\n");
        System.out.println("========= Vehiculos con costo menores a 1000 =========");
        List<Vehiculo> vehiculosNoMayor1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() < 1000.0).collect(Collectors.toList());
        vehiculosNoMayor1000.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("========= Vehiculos con costo mayores o iguales a 1000 =========");
        List<Vehiculo> vehiculosMayorIgual1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000.0).collect(Collectors.toList());
        vehiculosMayorIgual1000.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("========= Promedio costos vehiculos =========");
        Double promedioVehiculo = garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println("Promedio vehiculo " + Math.round(promedioVehiculo));

    }
}
