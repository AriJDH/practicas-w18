/* Consigna:
 * 7. Ejercicios Repaso Grupal
 * https://docs.google.com/document/d/1TzRCZbktSrVKZFet4UXpolYB63e7ic0o/edit
* */

import Clases.Persona;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------- Persona --------------------");

        //Ejercicio 4
        Persona persona1ConstructorVacio = new Persona();

        //Construcción de un objeto con un sólo parámetro: nombre
        /*
        No es posible ya que no está creado el constructor correspondiente.
        El IDE ofrece crear el constructor o utilizar los contructores existentes pasando
        los argumentos determinados
        */
        Persona persona2 = new Persona("Margarita");

        Persona persona3ConstructorSobrecargado = new Persona(
                "Ofelia", 70, "20987123", 55.0d,1.60d);

        System.out.println(persona3ConstructorSobrecargado);




    }
}