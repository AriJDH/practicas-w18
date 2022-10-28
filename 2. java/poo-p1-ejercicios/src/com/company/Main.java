package com.company;

import com.company.domain.Persona;

import java.nio.ReadOnlyBufferException;

public class Main {

    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona marcos = new Persona("Marcos", 22,"111111111");
        Persona roberto = new Persona("Roberto", 23,"111111111", 70.0,1.80);
        //Persona personaConstructorNoAdmitido = new Persona("Marcos",22);
        //Este ultimo no puede hacerse porque el constructor no esta definido

        System.out.println("Analizando a "+ roberto.getNombre()+"...");

        switch(roberto.calcularIMC()){
            case -1:
                System.out.println(roberto.getNombre()+" está bajo de peso.");
                break;
            case 0:
                System.out.println(roberto.getNombre()+" está bien de peso.");
                break;
            default:
                System.out.println(roberto.getNombre()+" tiene sobrepeso.");
                break;
        }
        String edad;
        if(roberto.esMayorDeEdad())
            edad="mayor de edad.";
        else
            edad="menor de edad.";
        System.out.println(roberto.getNombre()+" es " + edad);

        System.out.println("Datos de "+ roberto.getNombre());
        System.out.println(roberto.toString());
    }
}
