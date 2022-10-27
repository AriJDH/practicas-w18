package com.company;

public class Main {

    public static void main(String[] args) {
        // instancia de un vector en una sola linea de codigo
        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo", "Lima","Santiago de Chile","Lisboa","Tokio"};
        //instancia de vector, en varías lineas, como la teoría
        /*
        String ciu[] = new String[9];
        ciu[0] = "Londres";
        ...
        */
        //filas columnas
        int temperatura[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        //filas = temperaturas bajas
        //columnas = temperaturas altas

        //ciudad perteneciente
        int indiceMax = 0;
        int indiceMin = 0;

        int tempMaxima = temperatura[0][0];
        int tempMinima = temperatura[0][0];

        for (int x = 0; x < temperatura.length; x++){
            for (int y = 0; y < temperatura[x].length; y++){
                if(temperatura[x][y] > tempMaxima){
                    tempMaxima = temperatura[x][y];
                    indiceMax = x;
                }
                if(temperatura[x][y] < tempMinima){
                    tempMinima = temperatura[x][y];
                    indiceMin= x;

                }
            }
        }

        System.out.println("Temperatura maxima: " + tempMaxima + " Ciudad: " + ciudades[indiceMax]);
        System.out.println("Temperatura maxima: " + tempMinima + " Ciudad: " + ciudades[indiceMin]);
    }
}
