package com.company;


public class Main{
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 15, "100.1672.833");
        Persona persona3 = new Persona("Roberto", 20, "105.5782.433",80,1.76f);
        //Persona persona4 = new Persona("Felipe", 30);

        int imc = persona3.calcularIMC();
        System.out.println("Display info de la persona: \n" + persona3 + "\npeso: ");
        switch(imc){
            case -1:
                System.out.println("Bajo peso");
            case 0:
                System.out.println("Peso saludable");
            case 1:
                System.out.println("Sobrepeso");
        }
        System.out.println("\nMayoria de edad: ");
        boolean mayoriaEdad = persona3.esMayorDeEdad();
        System.out.println(mayoriaEdad?"Si":"No");

    }
}