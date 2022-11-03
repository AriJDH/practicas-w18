import java.util.*;

public class Main {
    public static void main(String[] args) {

        Vehiculo v1 = new Vehiculo("Ford","Focus",1200);
        Vehiculo v2 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo v3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo v4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo v5 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo v6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo v7 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo v8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo v9 = new Vehiculo("Toyota","Corola",1200);
        Vehiculo v10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo v11 = new Vehiculo("Renault","Logan",950);

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);
        vehiculos.add(v5);
        vehiculos.add(v6);
        vehiculos.add(v7);
        vehiculos.add(v8);
        vehiculos.add(v9);
        vehiculos.add(v10);
        vehiculos.add(v11);

        Garage garage = new Garage(1,vehiculos);
        System.out.println("Los vehiculos ordenados son:");

        vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);

        System.out.println("Ordenados por Marca y Precio");

        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Comparator.comparing(Vehiculo::getCosto)));
        vehiculos.forEach(System.out::println);

        System.out.println("Agrupados por precio menor a 1000");

        vehiculos.stream()
                 .filter((v) -> v.getCosto() < 1000)
                 .forEach(System.out::println);

        System.out.println("Agrupados por precio mayor/igual a 1000");

        vehiculos.stream()
                .filter((v) -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("Promedio total de precios");

        LongSummaryStatistics sum= vehiculos.stream().mapToLong((v)-> (long) v.getCosto()).summaryStatistics();
        System.out.println(sum.getAverage());
    }
}