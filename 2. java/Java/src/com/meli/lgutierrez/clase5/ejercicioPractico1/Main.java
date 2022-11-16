package com.meli.lgutierrez.clase5.ejercicioPractico1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Zara", "Camisa");
        Prenda prenda2 = new Prenda("Zara", "Pantalon");

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(Arrays.asList(prenda1, prenda2));
        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(1));

    }
}
