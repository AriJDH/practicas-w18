import clases.Garaje;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Garaje meli = new Garaje(1);


        meli.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        meli.getVehiculos().forEach(System.out::println);

        System.out.println(" ");
        System.out.println(" ");

        meli.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));
        meli.getVehiculos().forEach(System.out::println);


        System.out.println(" ");
        System.out.println(" ");


        System.out.println(meli.precioNoMayor());

        System.out.println(" ");
        System.out.println(" ");

        System.out.println(meli.precioMayor());

        System.out.println(" ");
        System.out.println(" ");

        System.out.println(meli.calcularPromedio());



    }
}
