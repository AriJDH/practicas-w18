package org.example;

import org.example.models.Garaje;
import org.example.models.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000.);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200.);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500.);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500.);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000.);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250.);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet","Aveo",1250.);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500.);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corolla",1200.);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000.);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950.);

        Garaje garaje = new Garaje(1);

        garaje.addVehiculos(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7,
                vehiculo8, vehiculo9, vehiculo10, vehiculo11);

        garaje.vehiculosPorPrecioDescendente();
        garaje.vehiculosPorMarcaYPrecio();
        garaje.vehiculosPrecioMenos1000();
        garaje.vehiculosPrecioMayorIgual1000();
        garaje.promedioPreciosVehiculos();
    }
}