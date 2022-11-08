package Generics.Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Fiesta","Ford",1000));
        vehiculos.add(new Vehiculo("Focus","Ford",1200));
        vehiculos.add(new Vehiculo("Explorer","Ford",2500));
        vehiculos.add(new Vehiculo("Uno","Fiat",500));
        vehiculos.add(new Vehiculo("Cronos","Fiat",1000));
        vehiculos.add(new Vehiculo("Torino","Fiat",1250));
        vehiculos.add(new Vehiculo("Aveo","Chevrolet",1250));
        vehiculos.add(new Vehiculo("Spin","Chevrolet",2500));
        vehiculos.add(new Vehiculo("Fortuner","Corola",1200));
        vehiculos.add(new Vehiculo("Fortuner","Toyota",3000));
        vehiculos.add(new Vehiculo("Logan","Renault",950));

        Garaje garaje = new Garaje(1, vehiculos);

        // Precio ordenado de mayor a menor //
        System.out.println("********Ordemaniento por precio**********");
        List<Vehiculo> ordenaPorCosto = garaje.getListaVehiculos().stream().sorted((x,y) -> Double.compare(x.getCosto(),y.getCosto())).collect(Collectors.toList());
        ordenaPorCosto.forEach(System.out::println);

        // Ordenar por Marca //
        System.out.println("********Ordenamiento por marca*********");
        List<Vehiculo> ordenaPorMarcaCosto = garaje.getListaVehiculos().stream().sorted((p,q) -> p.getMarca().compareTo(q.getMarca())).collect(Collectors.toList());
        ordenaPorMarcaCosto.forEach(System.out::println);

        // Vehiculos con precio <= 1000
        System.out.println("********Vehiculos con precio menor a mil*********");
        List<Vehiculo> vehiculoPrecioMenorAMil = garaje.getListaVehiculos().stream().filter(costo -> costo.getCosto() < 1000).collect(Collectors.toList());
        vehiculoPrecioMenorAMil.forEach(System.out::println);

        // Vehiculos con precio mayor a 1000
        System.out.println("********Vehiculos con precio mayor o igual a mil*********");
        List<Vehiculo> vehiculoPrecioMayorAMil = garaje.getListaVehiculos().stream().filter(costo -> costo.getCosto() >= 1000).collect(Collectors.toList());
        vehiculoPrecioMayorAMil.forEach(System.out::println);

        // Costo promedio
        System.out.println("********Costo promedio*********");
        double promedio = garaje.getListaVehiculos().stream().mapToDouble(a-> a.getCosto()).average().orElse(0);
        System.out.println("El costo promedio es: "+promedio);
    }
}
