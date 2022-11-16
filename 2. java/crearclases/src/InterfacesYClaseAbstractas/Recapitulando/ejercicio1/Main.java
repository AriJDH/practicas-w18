package InterfacesYClaseAbstractas.Recapitulando.ejercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);

        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000);
        garage.setVehiculos(vehiculo1);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",1200);
        garage.setVehiculos(vehiculo2);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",2500);
        garage.setVehiculos(vehiculo3);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",500);
        garage.setVehiculos(vehiculo4);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",1000);
        garage.setVehiculos(vehiculo5);
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat",1250);
        garage.setVehiculos(vehiculo6);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",1250);
        garage.setVehiculos(vehiculo7);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",2500);
        garage.setVehiculos(vehiculo8);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",1200);
        garage.setVehiculos(vehiculo9);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",3000);
        garage.setVehiculos(vehiculo10);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",950);
        garage.setVehiculos(vehiculo11);

        List<Vehiculo> vehicles = garage
                .getVehiculos()
                .stream()
                .sorted(
                        Comparator
                                .comparing(
                                        Vehiculo::getCosto
                                )
                ).collect(
                        Collectors
                                .toList()
                );
        vehicles.stream()
                .forEach(System.out::println);


        List<Vehiculo> marca = garage
                .getVehiculos()
                .stream()
                .sorted(Comparator.comparing(
                        Vehiculo::getMarca
                )
                        .thenComparing(Vehiculo::getCosto)
                )
                .collect(Collectors.toList());

        marca.stream()
                .forEach(System.out::println);

        List<Vehiculo> menorMil = garage
                .getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(
                        Collectors
                                .toList()
                );

        List<Vehiculo> mayorMil = garage
                .getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() > 1000)
                .collect(
                        Collectors
                                .toList()
                );

        double promedio = garage
                .getVehiculos()
                .stream()
                .collect(
                        Collectors
                                .averagingDouble(
                                        Vehiculo::getCosto
                                )
                );

        int array[] = {-1, 5, 3, 2, 8 };
        System.out.println(Ejercicio1.burbuja(array));
    }


}
