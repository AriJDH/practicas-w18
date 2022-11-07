package Paquete;

import Clases.Garaje;
import Clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        vehiculos.add( new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add( new Vehiculo("Ford","Focus",1200));
        vehiculos.add( new Vehiculo("Ford","Explorer",2500));
        vehiculos.add( new Vehiculo("Fiat","Uno",500));
        vehiculos.add( new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add( new Vehiculo("Fiat","Torino",1250));
        vehiculos.add( new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add( new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add( new Vehiculo("Toyota","Corola",1200));
        vehiculos.add( new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add( new Vehiculo("Renault","Logan",950));

        Garaje garaje = new Garaje(123,vehiculos);

        //Lista ordenada por precio de menor a mayor
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);

        //De mayor a menor
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);

        //Por precio y marca
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Vehiculos que valen menos de 1000 o 1000
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);

        //Vehiculos mayores a 1000
        garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(System.out::println);

        //Promedio total precios vehiculos
        garaje.getVehiculos().stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average().stream().forEach(System.out::println);

    }
}
