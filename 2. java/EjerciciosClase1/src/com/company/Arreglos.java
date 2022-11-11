package com.company;

import java.util.Scanner;

public class Arreglos {
    private Scanner scanner;
    private int[] sueldos;

    public void cargar(){
        scanner = new Scanner(System.in);
        sueldos = new int[5];
        for (int i = 0; i < 5; i++){
            System.out.println("Ingrese el valor");
            sueldos[i] = scanner.nextInt();
        }
    }

    public void imprimir(){
        for (int i = 0; i < 5; i++){
            System.out.println(sueldos[i]);
        }
    }

    public static void main(String[] args) {
        Arreglos arr = new Arreglos();
        arr.cargar();
        arr.imprimir();
    }
}
