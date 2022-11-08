import java.util.Scanner;

public class Estruc2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int num1, num2 , num3;
        System.out.println("Ingrese el primer número");
        num1 = teclado.nextInt();
        System.out.println("Ingrese el segundo número");
        num2 = teclado.nextInt();
        System.out.println("Ingrese el tercer número");
        num3 = teclado.nextInt();
        teclado.close();
        if (num1>num2 && num1>num3){
            System.out.println(num1);
        } else if (num2>num3){
            System.out.println(num2);
        } else {
            System.out.println(num3);
        }

    }
}
