package com.company;

import java.util.Scanner;

public class Estruc2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Ingrese los tres nums");
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();
        scanner.close(); // Se cierra el Scanner luego de terminar de pedir los datos

        if (num1 > num2 && num1 > num3){
            System.out.println(num1);
        } else if(num2 > num3){
            System.out.println(num2);
        } else {
            System.out.println(num3);
        }

    }





}
