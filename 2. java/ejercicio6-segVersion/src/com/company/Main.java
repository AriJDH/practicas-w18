package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // instancia de la clase garaje con lista de vehiculos
        Garaje g1 = new Garaje();
        Vehiculo vh = new Vehiculo();
        g1.setId("garaje1");

        //ingreso datos
        Vehiculo vehiculo1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault", "Logan", 950);

        g1.setLisado(vehiculo1);
        //de forma suseciva con los demas

        //muestra de datos, de forma ordenada de menor a mayor, segun el precio... para que quede mejor debería ir en la clase Garaje

        List<Vehiculo> lista = Arrays.asList(vehiculo1, vehiculo2, vehiculo3, vehiculo4, vehiculo5, vehiculo6, vehiculo7, vehiculo8, vehiculo8, vehiculo9, vehiculo10, vehiculo11);
        lista.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach((x) -> System.out.println(x.getCosto()));
        //lista.stream().sorted((v1,v2) -> v1.getCosto().compareTo(v2.getCosto())).forEach(System.out::println);

    }
}
