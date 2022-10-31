package com.meli.lgutierrez.clase1.tarde;

import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println("Nro de elementos" + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");
        arrayList.add("blanco");
        arrayList.add("amarillo");
        System.out.println("Nro de elementos: " + arrayList.size());
        System.out.println("El elemento que está en la posición 0 es: " + arrayList.get(0));
        System.out.println("El elemento que está en la posición 3 es: " + arrayList.get(3));
        System.out.println("Contenido de la lista: ");
        /*for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }*/

        //For Each
        for (String color: arrayList) {
            System.out.println(color);
        }

        if (arrayList.contains("blanco")){
            System.out.println("ese color está en la lista");
        }
        arrayList.remove("blanco");
        System.out.println("Contenido de la lista después de quitar: " +
                "primera ocurrencia del color");
        for (String color: arrayList) {
            System.out.println(color);
        }
        arrayList.remove(2);
        System.out.println("Contenido de la lista después de quitar: " +
                "elemento de la posición 2");
        for (String color: arrayList) {
            System.out.println(color);
        }
        arrayList.set(2, "turquesa");
        System.out.println("Contenido de la lista después de poner: " +
                "elemento en la posición 2");
        for (String color: arrayList) {
            System.out.println(color);
        }

    }
}
