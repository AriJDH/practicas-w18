package clase1;

import java.util.Scanner;

/* num1 > num2 10-15*/
public class Estructura4 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);
        int num1, num2;
        System.out.println("Ingrese el primer valor");
        num1 = Integer.parseInt((input.nextLine()));
        System.out.println("Ingrese el 2do valor");
        num2 = Integer.parseInt((input.nextLine()));

        while(num2 < num1){
            System.out.println("ERROR: el " + num2 + " es menor que " + num1);
            System.out.println("Ingrese el 2do valor");
            num2 = Integer.parseInt((input.nextLine()));
        }

       /* do {
            System.out.println("Ingrese el 2do valor");
            num2 = Integer.parseInt((input.nextLine()));
            if(num2 < num1)
                System.out.println("ERROR");
        } while (num2 < num1);

        System.out.println("Salí del ciclo... fin"); */
        System.out.println("Incluyéndolos");
        for (int i = num1; i<= num2; i++ ){
            System.out.println(i);
        }
        System.out.println("Excluyéndolos");
        for (int i = num1 + 1; i< num2; i++ ){
            System.out.println(i);
        }
        System.out.println("Invirtiéndolos");
        for (int i = num2; i> num1; i-- ){
            System.out.println(i);
        }

        input.close();
    }
}

