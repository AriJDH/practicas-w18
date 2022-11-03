package com.meli;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Fiesta", "Ford", 1000));
        carList.add(new Car("Focus", "Ford", 1200));
        carList.add(new Car("Explorer", "Ford", 2500));
        carList.add(new Car("Uno", "Fiat", 500));
        carList.add(new Car("Cronos", "Fiat", 1000));
        carList.add(new Car("Torino", "Fiat", 1250));
        carList.add(new Car("Aveo", "Chevrolet", 1250));
        carList.add(new Car("Spin", "Chevrolet", 2500));
        carList.add(new Car("Corola", "Toyota", 1200));
        carList.add(new Car("Fortuner", "Toyota", 3000));
        carList.add(new Car("Logan", "Renault", 950));

        Garage garage = new Garage(1, carList);

        //Mostrar lista de vehiculos ordenada por precios
        System.out.println("======================================");
        System.out.println("Lista de autos de menor a mayor costo:");
        garage.getCarList().stream().
                sorted((x, y) -> Double.compare(x.getCost(), y.getCost())).
                forEach(System.out::println);

        //Mostrar lista de vehiculos ordenada por precios y marca
        System.out.println("======================================");
        System.out.println("Lista de autos de menor a mayor costo y marca:");
        garage.getCarList().stream().
                sorted((x, y) -> Double.compare(x.getCost(), y.getCost())).
                sorted((w, z) -> w.getBrand().compareTo(z.getBrand())).
                forEach(System.out::println);

        //Lista de vehiculos con precio no mayor a 1000
        System.out.println("======================================");
        System.out.println("Lista de vehiculos con precio no mayor a 1000:");
        garage.getCarList().stream().
                filter((x) -> x.getCost() < 1000).
                forEach(System.out::println);

        //Lista de vehiculos con precio mayor o igual a 1000
        System.out.println("======================================");
        System.out.println("Lista de vehiculos con precio mayor o igual a 1000:");
        garage.getCarList().stream().
                filter((x) -> x.getCost() >= 1000).
                forEach(System.out::println);

        //Mostrar promedio de precios
        System.out.println("======================================");
        System.out.println("Mostrar promedio de precios:");
        var average = garage.getCarList().stream().
                mapToDouble(x -> x.getCost()).
                average().
                orElse(Double.NaN);
        System.out.println(average);
    }
}