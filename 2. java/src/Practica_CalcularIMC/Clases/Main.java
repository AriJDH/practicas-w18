package Practica_CalcularIMC.Clases;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();

        Persona persona2 = new Persona("Martin", 20, "123456");

        Persona persona3 = new Persona("Lucia", 22, "789456", 58, 160);

        System.out.println(persona3.calcularIMC());

        System.out.println(persona3);
    }
}
