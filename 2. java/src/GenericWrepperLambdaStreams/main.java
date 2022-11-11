package GenericWrepperLambdaStreams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {
    public static void main (String[] args){

        ArrayList<Vehiculo> vehiculoList = new ArrayList<Vehiculo>();
        vehiculoList.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculoList.add(new Vehiculo("Ford","Focus",1200));
        vehiculoList.add(new Vehiculo("Ford", "Explorer",2500));
        vehiculoList.add(new Vehiculo("Fiat","Uno",500));
        vehiculoList.add(new Vehiculo("Fiat","Cronos",100));
        vehiculoList.add(new Vehiculo("Fiat","Torino",1250));
        vehiculoList.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculoList.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculoList.add(new Vehiculo("Toyota","Corola",1200));
        vehiculoList.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculoList.add(new Vehiculo("Renault","Logan",950));

        Garaje garaje = new Garaje(1,vehiculoList);

        //Imprime la lista ordenada por precio de mayor a menor.
        vehiculoList.sort(
                Comparator.comparing(Vehiculo::getCosto).reversed()
        );

        //Imprimer la lista ordenada por marca y si son iguales por precio.
        vehiculoList.sort(
                Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto)
        );
        vehiculoList.forEach(vehiculo -> System.out.println(vehiculo.toString()));

        //Imprime la lista de vehiculos filtradas por precios no mayores a 1000.
        vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(vehiculo -> System.out.printf(vehiculo.toString()));

        List<Vehiculo> n = vehiculoList.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).collect(Collectors.toList());

        vehiculoList.forEach(vehiculo -> System.out.printf(vehiculo.toString()));


    }
}
