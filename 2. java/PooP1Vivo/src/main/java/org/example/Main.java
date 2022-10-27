package org.example;

/**
 * Class where the logic of the proposed exercise is executed
 *
 * @author: Juan Pablo Agudelo Florez
 */
public class Main {
    public static void main(String[] args) {
        Person personOne = new Person();
        Person personTwo = new Person("123", "juan", 23);
        Person personThree = new Person("1234", "alejandro", 18, 76f, 1.73f);
        int imc = personThree.ImcCalculate();
        System.out.println("-------------------------------------------------");
        System.out.println(personThree);
        System.out.println("Imc: " + (imc == -1 ? "Bajo peso" : (imc == 0 ? "Peso saludable" : "Sobrepeso")));
        System.out.println("¿Es mayor de edad?: " + personThree.IsOlder());
        System.out.println("-------------------------------------------------");
    }
}