package poo.exercises.pooLive1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exceptions {

  public static void main(String... args) {
    // try {
    //     FileInputStream fileInputStream = new FileInputStream("/Users/angeljutorre/Documents/angelDev/practicas-w18/2. java/Introduction/Bootcamp - introduction - Java/src/poo/exercises/pooLive1/prueba.txt");
    //     System.out.println(fileInputStream);
    //  } catch (FileNotFoundException exception) {
    //     System.out.println("El archivo indicado no existe");
    //  }
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";

    int[] numeros = new int[5];

    try {
      numeros[4] = 10;
      System.out.println(numeros[4]);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    } finally {
      System.out.println(mensajeFinal);
    }
  }
}
