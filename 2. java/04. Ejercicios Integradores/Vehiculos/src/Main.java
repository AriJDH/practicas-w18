import vehiculos.Garage;
import vehiculos.Vehiculo;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);
        Garage garage = new Garage(1,Arrays.asList(v1, v2, v3, v4, v5,v6, v7, v8, v9, v10, v11));

        /*

        // Mostrar Lista por Precio de Menor a Mayor (Ejercicio 1)
        garage.getListaVehiculos()
                .stream()
                .sorted(new PrecioComparator())
                .forEach(System.out::println);
        garage.getListaVehiculos()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio))
                .forEach(System.out::println);

        // Mostrar Lista por Marca y Precio de Menor a Mayor (Ejercicio 2)
        garage.getListaVehiculos()
                .stream()
                //.sorted(Comparator.comparingDouble(Vehiculo::getPrecio))
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getPrecio))
                .forEach(System.out::println);

        // Mostrar Lista de Precios no mayores a 1000 (Ejercicio 3)
        garage.getListaVehiculos()
                .stream()
                .filter(p->p.getPrecio()<=1000)
                .forEach(System.out::println);

        // Mostrar Lista de Precios no mayores a 1000 (Ejercicio 4)
        garage.getListaVehiculos()
                .stream()
                .filter(p->p.getPrecio()>=1000)
                .forEach(System.out::println);
         */

        // Mostrar Promedio de Precios (Ejercicio 5)
        Long tiempo = System.currentTimeMillis();
        Double promedio = (garage.getListaVehiculos()
                .stream()
                .mapToDouble(v -> v.getPrecio())
                .average()).orElse(0);
                //.sum()) / garage.getListaVehiculos().size();
        Double promedio2 = (garage.getListaVehiculos()
                .stream()
                        .collect(Collectors.averagingDouble(Vehiculo::getPrecio)));
        System.out.printf("$%.2f dólares\n",promedio);
        tiempo = System.currentTimeMillis() - tiempo;
        System.out.println(tiempo);


    }

}
