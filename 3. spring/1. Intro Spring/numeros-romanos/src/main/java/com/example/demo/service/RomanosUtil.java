package com.example.demo.service;

import org.springframework.stereotype.Service;


@Service
public class RomanosUtil {
    public RomanosUtil() {
    }

    public String convertirDecimalARomano(String decimal){

       String decimalAString = decimal.toString();

       String romano;

       //contar caracteres de decimalAString
       Integer cantidadCaracteres = decimalAString.length();

        System.out.println("Cantidad caracteres: " + cantidadCaracteres);

       //Descomponer cada dígito del número decimal
       //Miles, decenas, centenas, unidades
       //Ej 6344 = 6000 + 300 + 40 + 4

       String miles, centenas, decenas, unidades;

       unidades = decimalAString.substring(cantidadCaracteres-1);
       decenas = decimalAString.substring(cantidadCaracteres-2, cantidadCaracteres-1) + "0";
       centenas = decimalAString.substring(cantidadCaracteres-3, cantidadCaracteres-2) + "00";
       miles = decimalAString.substring(cantidadCaracteres-4, cantidadCaracteres-3) + "000";

/*       unidades = decimalAString.substring(cantidadCaracteres-1);
       decenas = decimalAString.substring(cantidadCaracteres-2, cantidadCaracteres-1);
       centenas = decimalAString.substring(cantidadCaracteres-3, cantidadCaracteres-2);
       miles = decimalAString.substring(0, cantidadCaracteres-3);*/

        System.out.println("Descomposición del número decimal: ");
        System.out.println("Unidad:" + unidades);
        System.out.println("Decenas:" + decenas);
        System.out.println("Centenas:" + centenas);
        System.out.println("Miles:" + miles);


        //sustituir cada composición por su equivalente a números romanos
        //Tener en cuenta las reglas de conversión

        String milesRomano = "";
        String centenasRomano = "";
        String decenasRomano = "";
        String unidadesRomano = "";

        //ROMANOS BASE
        String i = "I";
        String v = "V";
        String x = "X";
        String l = "L";
        String c = "C";
        String d = "D";
        String m = "M";


        //Unidades
        switch (unidades){
            case "1":
                unidadesRomano = i;
                break;
            case "2":
                unidadesRomano = i+i;
                break;
            case "3":
                unidadesRomano = i+i+i;
                break;
            case "4":
                unidadesRomano = i+v;
                break;
            case "5":
                unidadesRomano = v;
                break;
            case "6":
                unidadesRomano = v+i;
                break;
            case "7":
                unidadesRomano = v+i+i;
                break;
            case "8":
                unidadesRomano = v+i+i+i;
                break;
            case "9":
                unidadesRomano = i+x;
                break;
        }


        //decenas
        switch (decenas) {
            case "10":
                decenasRomano = x;
                break;
            case "20":
                decenasRomano = x+x;
                break;
            case "30":
                decenasRomano = x+x+x;
                break;
            case "40":
                decenasRomano = x+l;
                break;
            case "50":
                decenasRomano = l;
                break;
            case "60":
                decenasRomano = l+x;
                break;
            case "70":
                decenasRomano = l+x+x;
                break;
            case "80":
                decenasRomano = l + x + x + x;
                break;
            case "90":
                decenasRomano = x + c;
                break;
        }


        //centenas
        switch (centenas) {
            case "100":
                centenasRomano = c;
                break;
            case "200":
                centenasRomano = c + c;
                break;
            case "300":
                centenasRomano = c + c + c;
                break;
            case "400":
                centenasRomano = c+d;
                break;
            case "500":
                centenasRomano = d;
                break;
            case "600":
                centenasRomano = d+c;
                break;
            case "700":
                centenasRomano = d+c+c;
                break;
            case "800":
                centenasRomano = d+c+c+c;
                break;
            case "900":
                centenasRomano = c+m;
                break;
        }

        //miles
        switch (miles){
            case "1000":
                milesRomano = m;
                break;
            case "2000":
                milesRomano = m+m;
                break;
            case "3000":
                milesRomano = m+m+m;
                break;
            case "4000":
                milesRomano = "["+ i + v +"]";
                break;
            case "5000":
                milesRomano = "[" + v + "]";
                break;
            case "6000":
                milesRomano = "["+ v + i +"]";
                break;
            case "7000":
                milesRomano = "["+ v + i + i +"]";
                break;
            case "8000":
                milesRomano = "["+ v + i + i + i +"]";
                break;
            case "9000":
                milesRomano = "["+ i + x +"]";
                break;
            case "10000":
                milesRomano = "["+ x +"]";
                break;
        }

        System.out.print(milesRomano);
        System.out.print( " " + centenasRomano);
        System.out.print( " " + decenasRomano);
        System.out.println( " " + unidadesRomano);

        /*
       * 1. Los números romanos I, X, C y M pueden repetirse hasta 3 veces a la hora de escribir un número romano compuesto.
       * 2. Los números romanos V, L y D no pueden repetirse nunca
       * 3. Si un número romano compuesto tiene un número a la derecha menor que el de la izquierda entonces se suman ambos
       * 3.1. EJ  XI: el número de la derecha (I = 1) es menor que el de la izquierda (X = 10) entonces se suman -> XI = 11
       * 4. Si un número romano compuesto tiene un número a la derecha mayor que el de la izquierda y éste es un I, X o C, entonces se resta el de la izquierda:
       * 4.1. EJ IX: El número de la derecha (X = 10) es mayor que el de la izquierda (I = 1) y además este es I, luego se resta el de la izquierda al de la derecha -> IX = 9
       * 5. Si un número romano tiene sobre él una raya, entonces su valor se multiplica por mil
       * 5.1. Ej. IX ( <- SUPONGAMOS QUE TIENE UNA RAYA ARRIBA) número 9 puesto que es el número romano 9, al tener la raya arriba se multiplica por mil
       * */


       romano = milesRomano + centenasRomano + decenasRomano + unidadesRomano;
       return romano;
   }

}
