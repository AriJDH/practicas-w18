package clase4_a_EjerciciosIntegrador.Ej1;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Vehiculo veh1 = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo veh2 = new Vehiculo("Ford", "Focus", 1200.0);
        Vehiculo veh3 = new Vehiculo("Ford", "Explorer", 2500.0);
        Vehiculo veh4 = new Vehiculo("Fiat", "Uno", 500.0);
        Vehiculo veh5 = new Vehiculo("Fiat", "Cronos", 1000.0);
        Vehiculo veh6 = new Vehiculo("Fiat", "Torino", 1250.0);
        Vehiculo veh7 = new Vehiculo("Chevrolet", "Aveo", 1250.0);
        Vehiculo veh8 = new Vehiculo("Chevrolet", "Spin", 2500.0);
        Vehiculo veh9 = new Vehiculo("Toyota", "Corola", 1200.0);
        Vehiculo veh10 = new Vehiculo("Toyota", "Fortuner", 3000.0);
        Vehiculo veh11 = new Vehiculo("Renault", "Logan", 950.0);
        Garage garage = new Garage(1, Arrays.asList(veh1, veh2, veh3, veh4, veh5, veh6, veh7, veh8, veh9, veh10, veh11));

        System.out.println("----------------------------------------------------");
        System.out.println("Lista de vehiculos ordenada por costo:");
        System.out.println("----------------------------------------------------");
        garage.getListaVehiculo().stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .forEach(System.out::println);

        /*
        garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
         */

        System.out.println("----------------------------------------------------");
        System.out.println("Lista de vehiculos ordenado por marca y costo");
        System.out.println("----------------------------------------------------");
        garage.getListaVehiculo().stream()
                .sorted((x,y) -> x.getCosto().compareTo(y.getCosto()))
                .sorted((x,y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.println("Lista de vehiculos con precio hasta 1000");
        System.out.println("----------------------------------------------------");
        garage.getListaVehiculo()
                .stream()
                .filter(x-> x.getCosto() <= 1000)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.println("Lista de vehiculos con precios mayores a 1000");
        System.out.println("----------------------------------------------------");
        garage.getListaVehiculo()
                .stream()
                .filter(x-> x.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("----------------------------------------------------");
        System.out.print("Promedio de costo de vehículos: ");
        Double promedio = garage.getListaVehiculo()
                .stream()
                .mapToDouble(x-> x.getCosto()).average().orElse(Double.NaN); //.getAsDouble();
        //System.out.println((double)Math.round(promedio * 100d) / 100d);
        System.out.printf("$%.2f\n", promedio);
        System.out.println("----------------------------------------------------");
    }
}
