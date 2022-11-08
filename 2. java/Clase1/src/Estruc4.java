import java.util.Scanner;

public class Estruc4 {
    public static void main(String[] args){
        final Scanner input = new Scanner(System.in);
        int num1,num2;
        System.out.println("Ingrese el primer valor");
        num1 = Integer.parseInt(input.nextLine());
        System.out.println("Ingrese el segundo valor");
        num2 = Integer.parseInt(input.nextLine());

        while (num2<num1){
            System.out.println("ERROR: el "+ num2 + num1 );
            System.out.println("Ingrese el segundo valor");
            num2 = Integer.parseInt(input.nextLine());
        }
        input.close();

    }

}
