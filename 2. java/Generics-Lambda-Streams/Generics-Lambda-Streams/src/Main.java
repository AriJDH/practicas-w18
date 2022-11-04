import clases.Garaje;
import clases.Vehiculo;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Garaje meli = new Garaje(1);
        System.out.println("****************************************************");
        System.out.println("Lista ordenada por costo");
        meli.getVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        meli.getVehiculos().forEach(System.out::println);
        System.out.println("****************************************************");
        System.out.println("Lista ordenada por marca");
        meli.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca));
        meli.getVehiculos().forEach(System.out::println);
        System.out.println("****************************************************");
        System.out.println("Lista ordenada por precio no mayoR a 10000");
        System.out.println(meli.precioNoMayor());
        System.out.println("****************************************************");
        System.out.println("Lista ordenada por precio mayor o igual a 10000");
        System.out.println(meli.precioMayor());
        System.out.println("****************************************************");
        System.out.println("Promedio");
        System.out.println(meli.calcularPromedio());
    }
}
