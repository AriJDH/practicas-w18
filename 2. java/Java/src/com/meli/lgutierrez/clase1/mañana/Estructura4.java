package com.meli.lgutierrez.clase1.mañana;

import java.util.Scanner;

public class Estructura4 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingrese el primer valor: ");
        num1 = Integer.parseInt(teclado.nextLine());
        System.out.println("Ingrese el segundo valor: ");
        num2 = Integer.parseInt(teclado.nextLine());

        /*while(num2 < num1){
            System.out.println("ERROR: el " + num2 + " es menor que " + num1);
            System.out.println("Ingrese el segundo valor: ");
            num2 = Integer.parseInt(teclado.nextLine());
        }*/

        /*do {
            System.out.println("Ingrese el segundo valor: ");
            num2 = Integer.parseInt(teclado.nextLine());
            if (num2 < num1)
                System.out.println("ERROR: el " + num2 + " es menor que " + num1);
        } while (num2 < num1);
        */
        System.out.println("Incluyendo los valores");
        for (int i = num1; i <= num2; i++) {
            System.out.println(i);
        }

        System.out.println("Excluyendo los valores");
        for (int i = num1 + 1; i < num2; i++) {
            System.out.println(i);
        }

        System.out.println("Invirtiendo los valores");
        for (int i = num2; i >= num1; i--) {
            System.out.println(i);
        }

        System.out.println("Salí del ciclo... fin");
        teclado.close();
    }
}
