import Clases.Garage;
import Clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listaVehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garage garaje = new Garage(1, listaVehiculos);

        System.out.println("-------Ejercicio 3: ordenar de menor a mayor----------\n");
        List<Vehiculo> vehiculosPorCosto = garaje.getListaVehiculos().stream().sorted((x, y) -> x.getCosto().compareTo(y.getCosto())).collect(Collectors.toList());

        vehiculosPorCosto.forEach(System.out::println);
        System.out.println();

        System.out.println("----------Ejercicio 4: ordenar por marca y costo----------\n");
        List<Vehiculo> vehiculosPorMarcaCosto = vehiculosPorCosto.stream().sorted((x, y) -> x.getMarca().compareTo(y.getMarca())).collect(Collectors.toList());

        vehiculosPorMarcaCosto.forEach(System.out::println);

        System.out.println("\n----------Ejercicio 5: extraer vehiculos menor a 1000, igual o mayor a 1000 y promedio--------- \n");

        ArrayList<Vehiculo> vehiculosMenor1000 = (ArrayList<Vehiculo>) listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000).collect(Collectors.toList());

        System.out.println("Vehiculos con costo menor a 1000.");
        vehiculosMenor1000.forEach(System.out::println);

        ArrayList<Vehiculo> vehiculosMayorIgual1000 = (ArrayList<Vehiculo>) listaVehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).collect(Collectors.toList());

        System.out.println("Vehiculos con costo >= 1000");
        vehiculosMayorIgual1000.forEach(System.out::println);

        Double promedio = listaVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();

        System.out.println("\nEl promedio de toda la lista de vehiculos es: "+promedio);

    }
}
