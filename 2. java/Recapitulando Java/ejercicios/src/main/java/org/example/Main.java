package org.example;

import org.example.domain.Garaje;
import org.example.domain.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(1L);
        garaje.addVehiculo(new Vehiculo("Ford", "Fiesta",1000));
        garaje.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garaje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));

        System.out.println("-----------------VEHICULOS-----------------");
        garaje.getVehiculos().stream().forEach(v-> System.out.println(v.toString()));
        System.out.println("-----------------VEHICULOS ORDENADOS POR PRECIO-----------------");
        garaje.getVehiculos().sort((v1,v2)->Vehiculo.compareCosto(v1,v2));
        garaje.getVehiculos().forEach(v-> System.out.println(v.toString()));
        System.out.println("-----------------VEHICULOS ORDENADOS POR MARCA Y PRECIO-----------------");
        garaje.getVehiculos().sort((v1,v2)->Vehiculo.compareMarca(v1,v2));
        garaje.getVehiculos().sort((v1,v2)->Vehiculo.compareCosto(v1,v2));
        garaje.getVehiculos().forEach(v-> System.out.println(v.toString()));
        System.out.println("-----------------VEHICULOS CON PRECIO <=1000-----------------");
        garaje.getVehiculos().stream().filter(v->v.getCosto()<=1000).forEach(v-> System.out.println(v.toString()));
        System.out.println("-----------------VEHICULOS CON PRECIO >1000-----------------");
        garaje.getVehiculos().stream().filter(v->v.getCosto()>1000).forEach(v-> System.out.println(v.toString()));
        System.out.println("-----------------PROMEDIO DE PRECIOS-----------------");
        System.out.println(garaje.getVehiculos().stream().mapToDouble(v->v.getCosto()).average().getAsDouble());

    }
}