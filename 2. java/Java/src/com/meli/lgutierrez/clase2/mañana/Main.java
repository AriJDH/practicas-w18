package com.meli.lgutierrez.clase2.mañana;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Laura", 29, "1115080737");
        Persona persona3 = new Persona("Clara", 27, "1115489624", 60, 180);

        //Persona persona4 = new Persona("Cecilia", 29);

        if (persona3.esMayorEdad()){
            System.out.println("La persona " + persona3.getNombre() + " es mayor de edad");
        }else {
            System.out.println("La persona " + persona3.getNombre() + " es menor de edad");
        }
        System.out.println(persona3.mostrarPersona());


    }
}
