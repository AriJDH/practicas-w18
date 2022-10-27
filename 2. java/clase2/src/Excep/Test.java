package Excep;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        try{
            FileInputStream st = new FileInputStream("estoNoExiste.txt");
        }catch(FileNotFoundException e){
            e.printStackTrace(System.out);
        }

        int cero = 0;
        double boom = 10 / cero;
    }
}
