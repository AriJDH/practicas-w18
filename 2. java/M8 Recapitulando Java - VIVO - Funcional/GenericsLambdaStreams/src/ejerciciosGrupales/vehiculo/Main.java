package ejerciciosGrupales.vehiculo;

import ejerciciosGrupales.vehiculo.domain.Garage;
import ejerciciosGrupales.vehiculo.domain.Vehiculo;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo fordFiesta = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo fordFocus = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo fordExplorer = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo fiatUno = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo fiatTorino = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo chevroletAveo = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo chevroletSpin = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo toyotaCorola = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo toyotaFortuner = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo renaultLogan = new Vehiculo("Renault", "Logan", 950);

        List<Vehiculo> vehiculos = List.of(
                fordFiesta,
                fordFocus,
                fordExplorer,
                fiatUno,
                fiatCronos,
                fiatTorino,
                chevroletAveo,
                chevroletSpin,
                toyotaCorola,
                toyotaFortuner,
                renaultLogan
        );

        Garage garage = new Garage(vehiculos);


        System.out.println("\n ---------Ordenado por Costo ------------ ");
        garage.getVehiculos().stream()
               // .sorted((o1, o2) -> o1.getCosto().compareTo(o2.getCosto()))
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n ---------Ordenado por Marca y Costo ------------ ");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))  //Así ordena primero por Marca y luego por costo
                .sorted(Comparator.comparing(Vehiculo::getMarca))  //Si invierto las sentencias ordena por costo y luego por marca
                .forEach(System.out::println);

        System.out.println("\n --------- Vehículos costo < 1000 ------------ ");
        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n --------- Vehículos costo >= 1000 ------------ ");
        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\n --------- Promedio de precios de toda la lista ------------ ");
        OptionalDouble promedio = garage.getVehiculos().stream()
                .mapToInt(value -> value.getCosto())
                .average();

        System.out.println("promedio: $" + Math.round(promedio.getAsDouble()));


        System.out.println("\n --------- matToDouble Promedio de precios de toda la lista ------------ ");
        Double promedioD = garage.getVehiculos().stream()
                .mapToDouble(value -> value.getCosto())
                .average()
                .orElse(Double.NaN);

        System.out.println("Promedio: $" + Math.round(promedioD));


        System.out.println("\n --------- AveragingDouble - Promedio de precios de toda la lista ------------ ");

        double promedioAvg = garage.getVehiculos().stream()
                .collect(Collectors
                        .averagingDouble(Vehiculo::getCosto));



        //otra forma de imprimir lista
        //vehiculos.stream().collect(Collectors.toList())
        //        .forEach((x) -> System.out.println(x));

    }
}
