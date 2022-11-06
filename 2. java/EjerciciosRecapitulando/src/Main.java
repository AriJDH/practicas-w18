import Vehiculos.Garaje;
import Vehiculos.Vehiculo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota",3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

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

        System.out.println(list);

        /*  Collections.sort(listaVehiculos, (v1, v2) -> v1.getCosto().compareTo(v2.getCosto())); */

        List<Vehiculo> sortedList = list.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(sortedList);

        List<Vehiculo> sortedList2 = list.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println(sortedList2);


        Garaje garaje = new Garaje(1,list);


    }
}
