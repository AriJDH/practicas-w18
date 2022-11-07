import vehiculos.Garage;
import vehiculos.Vehiculo;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos =new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault","Logan",950));

        Garage garage = new Garage(11111,vehiculos);

        //Stream.of(vehiculos).map(vehiculo -> vehiculo.toString()).forEach(System.out::println);

        //Ejercicio 3
        System.out.println("Ordeno por precio");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 4
        System.out.println("Ordeno por marca");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);
        System.out.println("Hello world!");

        //Ejercicio 5
        /*Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual
        1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.
         * */
        System.out.println("Lista de vehiculos con precio no mayor a 1000:");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        System.out.println("Lista de vehiculos con precios mayor o igual a 1000.");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);

        OptionalDouble promedio = vehiculos.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average();
        System.out.println("Promedio total de precios: "+promedio.getAsDouble());
    }
}