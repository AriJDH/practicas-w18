import java.util.ArrayList;

/*
CONSIGNA:
https://docs.google.com/document/d/1AmqBIKRfYgoWFQIFnEjx43JILe95yfyjdUxkWFUlnUg/edit
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(" ----------- TEMPERATURAS GLOBALES ----------- ");

        String ciudades [] = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires",
                "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int temperaturas [][] = {
                {-2,33},
                {-3,32},
                {-8,27},
                {4,37},
                {6,42},
                {5,43},
                {0,39},
                {-7,26},
                {-1,31},
                {-10,35}
        };

        String ciudadMinTemp = ciudades[0];
        String ciudadMaxTemp = ciudades[0];

        int temperaturaMin = temperaturas[0][0];
        int temperaturaMax = temperaturas[0][1];


        for (int i = 0; i < temperaturas.length; i++) {

            if(temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadMaxTemp = ciudades[i];
            }

            if(temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadMinTemp = ciudades[i];
            }

        }

        System.out.println("Temperatura MÁXIMA: " + temperaturaMax + " · " + ciudadMaxTemp);
        System.out.println("Temperatura mínima: " + temperaturaMin + " · " + ciudadMinTemp);

    }

}