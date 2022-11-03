package meli.bootcamp;

import meli.bootcamp.clases.Garaje;
import meli.bootcamp.clases.Vehiculo;

import java.util.Comparator;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Garaje meli = new Garaje(1);

        System.out.println("ORDENADO DE MENOR A MAYOR");
        meli.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        meli.getVehiculos().forEach(System.out::println);
        System.out.println("ORDENADO POR MARCA MENOR A MAYOR");
        meli.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));
        meli.getVehiculos().forEach(System.out::println);
        System.out.println("LISTA DE VEHICULOS CON PRECIO MENOR A 1000");
        System.out.println(meli.precioNoMayor());
        System.out.println("LISTA DE VEHICULOS CON PRECIO MAYOR O IGUAL A 10000");
        System.out.println(meli.precioMayor());
        System.out.println(meli.calcularPromedio());
    }
}
