package clase1_b;

import java.util.ArrayList;

public class EjArrList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("rojo");
        arrayList.add("verde");
        arrayList.add("azul");
        System.out.println("Nro de elementos: " + arrayList.size());
        arrayList.add("blanco");
        arrayList.add("amarillo");
        System.out.println("Nro de elementos: " + arrayList.size());
        System.out.println("El elemento que está en la posición 0 es : " + arrayList.get(0));
        System.out.println("El elemento que está en la posición 3 es : " + arrayList.get(3));
        System.out.println("Contenido de la lista:");
        for ( int i = 0; i < arrayList.size(); i ++ ){
            System.out.println(arrayList.get(i));
        }
        for ( String color : arrayList) {
            System.out.println(color);
        }
        if ( arrayList.contains("blanco") ){
            System.out.println("El color blanco se encuentra en la lista");
        } else {
            System.out.println("El color blanco no se encuentra en la lista");
        }
        arrayList.remove("blanco");
        System.out.println("Contenido luego de borrar el color blanco");
        for ( String color : arrayList) {
            System.out.println(color);
        }
        arrayList.remove(2  );
        System.out.println("Contenido luego de borrar el color de la posición 2");
        for ( String color : arrayList) {
            System.out.println(color);
        }
        arrayList.set(2, "turquesa");
        System.out.println("Contenido luego de agregar un color en la posición 2");
        for ( String color : arrayList) {
            System.out.println(color);
        }



    }
}
