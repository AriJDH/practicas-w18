package com.meli.lgutierrez.clase1.mañana;

import java.util.Scanner;

public class Arreglo {
    private Scanner teclado;
    private int[] sueldos;

    public void cargarInformacion(){
        teclado = new Scanner(System.in);
        sueldos = new int[5];

        for (int i = 0; i < sueldos.length; i++) {
            System.out.println("Ingrese un valor: ");
            sueldos[i] = teclado.nextInt();
        }
    }

    public void imprimirInformacion(){
        for (int i = 0; i < 5; i++) {
            System.out.println(sueldos[i]);
        }
    }

    public static void main(String[] args) {
        Arreglo arreglo = new Arreglo();
        arreglo.cargarInformacion();
        arreglo.imprimirInformacion();
    }
}
