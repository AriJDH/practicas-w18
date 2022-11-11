package com.company;

import java.util.ArrayList;

public class ExP2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("Buenos Aires");
        arrayList.add("Cordoba");
        arrayList.add("Rosario");
        arrayList.add("Santa Fe");
        arrayList.add("Misiones");
        arrayList.add("Chaco");
        System.out.println("Nro de elementos: " + arrayList.size());
        System.out.println("El elemento en la posicion 1 es: " + arrayList.get(1));

        // for regular
        /*
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        */

        // for each
        for (String city : arrayList){
            System.out.println(city);
        }

        if (arrayList.contains("Chaco")){
            System.out.println("----------------------------------------------");
        }

        arrayList.remove("Misiones");
        arrayList.remove("Misiones");


        // Modifica el contenido en el index dado
        arrayList.set(0, "San Luis");

        for (String city : arrayList){
            System.out.println(city);
        }
    }
}
