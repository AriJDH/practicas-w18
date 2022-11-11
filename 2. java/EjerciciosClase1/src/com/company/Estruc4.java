package com.company;

import java.util.Scanner;

public class Estruc4 {
    public static void main(String[] args) {
         final Scanner scanner = new Scanner(System.in);
         int num1, num2;
         System.out.println("Num1 y num2");
         num1 = Integer.parseInt(scanner.nextLine());
         num2 = Integer.parseInt(scanner.nextLine());


         while(num1 > num2){
             System.out.println("ERROR: el " + num2 + " es menor que " + num1);
             System.out.println("Vuelva a ingresar el num2");
             num2 = Integer.parseInt(scanner.nextLine());
         }

         for (int i = num1; i < num2; i++){
             System.out.println(i);
         }



    }
}
