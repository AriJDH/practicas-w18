package com.company;

import java.util.Scanner;

public class Main {
    static final int INDEX_MAX = 1;
    static final int INDEX_MIN = 0;

    public static void main(String[] args) {
        // write your code here

        String ciudades[] = new String[10];
        double temperaturas[][] = new double[10][2];
        String ciudadMin = "";
        String ciudadMax = "";
        double tempMin = Double.POSITIVE_INFINITY;
        double tempMax = Double.NEGATIVE_INFINITY;

        Scanner tecladoCiudades = new Scanner(System.in);
        Scanner tecladoTemps = new Scanner(System.in);

        // Cargar datos
        for(int i = 0; i < 10; i++) {
            System.out.println("Ingrese ciudad " + i + ": ");
            ciudades[i] = tecladoCiudades.nextLine();

            System.out.println("Ingrese temperatura minima: ");
            temperaturas[i][INDEX_MIN] = tecladoTemps.nextDouble();
            System.out.println("Ingrese temperatura maxima: ");
            temperaturas[i][INDEX_MAX] = tecladoTemps.nextDouble();
        }

        // Resolver
        for(int i = 0; i < ciudades.length; i++) {
            if(temperaturas[i][INDEX_MIN] < tempMin) {
                tempMin = temperaturas[i][INDEX_MIN];
                ciudadMin = ciudades[i];

            }
            if(temperaturas[i][INDEX_MAX] > tempMax) {
                tempMax = temperaturas[i][INDEX_MAX];
                ciudadMax = ciudades[i];
            }
        }

        System.out.println("Temperatura máxima: " + tempMax + " en ciudad: " + ciudadMax);
        System.out.println("Temperatura mínima: " + tempMin + " en ciudad: " + ciudadMin);
    }
}
