package ej1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
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
        Vehiculo vehiculo11= new Vehiculo("Renault", "Logan", 950);

        ArrayList<Vehiculo> list = new ArrayList<>();

        list.add(vehiculo1);
        list.add(vehiculo2);
        list.add(vehiculo3);
        list.add(vehiculo4);
        list.add(vehiculo5);
        list.add(vehiculo6);
        list.add(vehiculo7);
        list.add(vehiculo8);
        list.add(vehiculo9);
        list.add(vehiculo10);
        list.add(vehiculo11);

        Garage garage = new Garage(1, list);
        garage.ordenarAsc();
        System.out.println("*************************************************************+");
        garage.ordenarAsc2();
        System.out.println("*************************************************************+");
        garage.menoresA1k();
        System.out.println("*************************************************************+");
        garage.mayoresA1k();
        System.out.println("*************************************************************+");


        // Collections.sort(list, (v1, v2) -> v1.getCosto().compareTo(v2.getCosto()));

        //List<Vehiculo> sortedList = list.stream()
          //      .sorted(Comparator.comparing(Vehiculo::getCosto))
            //    .collect(Collectors.toList());
        //System.out.println(sortedList);

        /*
        List<Vehiculo> sortedList2 = list.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(sortedList2);

         */

        /*
        List<Vehiculo> sortedList2 = list.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList());
        System.out.println(sortedList2);

         */
    }

}
