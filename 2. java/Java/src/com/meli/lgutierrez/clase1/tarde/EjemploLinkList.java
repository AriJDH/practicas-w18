package com.meli.lgutierrez.clase1.tarde;

import java.util.LinkedList;

public class EjemploLinkList {

    public static void imprimir(LinkedList<String> lista){
        for (String elemento : lista){
            System.out.print(elemento + "-");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Independiente");
        lista.add("Nacional");
        lista.add("Patronato");
        lista.add("River");
        lista.add("Atl Nacional");

        imprimir(lista);
        lista.add(3, "Boca");
        lista.remove(2);
        lista.remove("Nacional");
        imprimir(lista);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

    }
}
