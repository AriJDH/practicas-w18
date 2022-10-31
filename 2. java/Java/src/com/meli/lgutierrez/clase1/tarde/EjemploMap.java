package com.meli.lgutierrez.clase1.tarde;

import java.util.HashMap;
import java.util.Map;

public class EjemploMap {
    public static void main(String[] args) {
        HashMap<Integer, String> mapa = new HashMap<>();
        mapa.put(924, "Gabriel Guerra");
        mapa.put(921, "Nicolás Sánchez");
        mapa.put(700, "Esteban Quito");
        mapa.put(537, "Johana Santos");
        mapa.put(605, "Daniel Otero");
        System.out.println("Los elementos del diccionario son: \n" + mapa);
        System.out.println(mapa.get(700));
        System.out.println("Todas las entradas del diccionario extraidas con entrySet: \n");
        System.out.println(mapa.entrySet());
        System.out.println("Todas las entradas del diccionario extraidas una a una: \n");
        for (Map.Entry pareja : mapa.entrySet()){
            System.out.println(pareja);
        }

        System.out.println("Código\tNombre\n-----------\t----------");
        for (Map.Entry pareja : mapa.entrySet()){
            System.out.print(pareja.getKey() + "\t");
            System.out.println(pareja.getValue());
        }
    }
}
