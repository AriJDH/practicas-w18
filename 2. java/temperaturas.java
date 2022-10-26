package com.company;


public class Main {

    public static void main(String[] args) {

        String vectorCiudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao paulo","Lima","Santiago de Chile","Lisboa","Tokio"}; //10
        double matrizTemperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};//10-2
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;


        tempMinima = matrizTemperaturas[0][0];
        ciudadMinima = vectorCiudades[0];
        tempMaxima = matrizTemperaturas[0][0];
        ciudadMaxima = vectorCiudades[0];
        
        for (int f = 0; f <= 9; f++) {
            for (int c = 0; c <= 1; c++) {

                
                if (matrizTemperaturas[f][c]<tempMinima){
                    tempMinima=matrizTemperaturas[f][c];
                    ciudadMinima=vectorCiudades[f];
                }
                
                if (matrizTemperaturas[f][c]>tempMaxima){
                    tempMaxima=matrizTemperaturas[f][c];
                    ciudadMaxima=vectorCiudades[f];
                }

            }

        }

        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);
    }
}
