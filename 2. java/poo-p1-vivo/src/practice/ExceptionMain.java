package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionMain {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int valor = 0;
            double result = 10 / valor;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("END");
    }
}
