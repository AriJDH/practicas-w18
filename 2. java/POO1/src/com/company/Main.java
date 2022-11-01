package com.company;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jhonier",25,"1020479359");
        Persona persona3 = new Persona("Juan",38,"98710089",78.5,1.78);
        //Persona persona4 = new Persona("Mery",62);
        System.out.println(persona3.toString());
        int imc = persona3.calcularIMC(persona3.getPeso(),persona3.getAltura());
        switch (imc){
            case -1:{
                System.out.println("Bajo Peso");
                break;
            }
            case 0:{
                System.out.println("Peso saludable");
                break;
            }
            case 1: {
                System.out.println("Sobrepeso");
                break;
            }
        }
        boolean esMayor = persona3.esMayorDeEdad(persona3.getEdad());
        if (esMayor){
            System.out.println("Es mayor de edad");
        }
        else {
            System.out.println("Es menor de edad");
        }


    }
}
