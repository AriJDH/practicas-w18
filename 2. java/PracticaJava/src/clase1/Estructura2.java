package clase1;

import java.util.Scanner;

public class Estructura2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2, num3;
        System.out.println("Ingrese el primer número");
        num1 = teclado.nextInt();
        System.out.println("Ingrese el 2do número");
        num2 = teclado.nextInt();
        System.out.println("Ingrese el 3er número");
        num3 = teclado.nextInt();
        teclado.close();
        if (num1 > num2 && num1 > num3){ //gana el 1
            System.out.println(num1);
        } else if(num2 > num3){ // gana 2
            System.out.println(num2);
        } else {  // gana el 3
            System.out.println(num3);
        }
    }
}
