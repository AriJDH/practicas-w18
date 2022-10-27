package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nombre = "";
        int edad = 0;
        String dni = "";
        float peso = 0;
        float altura = 0;

        Persona personaConstrVacio = new Persona();
        Persona personaConstrMedio = new Persona(nombre, edad, dni);
        Persona personaConstrCompleto = new Persona(nombre, edad, dni, peso, altura);

        /**Crear un objeto pasando por parametro unicamente nombre y edad no se puede,
         ya que no tenemos un constructor de ese formato*/

        System.out.println("Ingrese nombre: ");
        nombre = teclado.nextLine();
        personaConstrCompleto.setNombre(nombre);

        System.out.println("Ingrese edad: ");
        edad = teclado.nextInt();
        teclado.nextLine();
        personaConstrCompleto.setEdad(edad);

        System.out.println("Ingrese dni: ");
        dni = teclado.nextLine();
        personaConstrCompleto.setDni(dni);

        System.out.println("Ingrese peso: ");
        peso = teclado.nextFloat();
        teclado.nextLine();
        personaConstrCompleto.setPeso(peso);

        System.out.println("Ingrese altura: ");
        altura = teclado.nextFloat();
        teclado.nextLine();
        personaConstrCompleto.setAltura(altura);

        teclado.close();

        int imc= personaConstrCompleto.calcularIMC();

        boolean mayor = personaConstrCompleto.esMayorDeEdad(edad); //personaConstrCompleto.getEdad();

        personaConstrCompleto.toString();

    }
}

