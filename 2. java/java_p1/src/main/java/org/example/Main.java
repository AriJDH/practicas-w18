package org.example;

public class Main {
    public static void main(String[] args) {

        String cities[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo", "Lima",
                "Santiago de Chile","Lisboa","Tokio"};
        int temp[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};

        int maxTemp = temp[0][1];
        int minTemp = temp[0][0];
        String cityMax = cities[0];
        String cityMin = cities[0];

        for (int i = 0; i < temp.length; i++) {
            if (temp[i][0] < minTemp) {
                minTemp = temp[i][0];
                cityMin = cities[i];
            }
            if (temp[i][1] > maxTemp) {
                maxTemp = temp[i][1];
                cityMax = cities[i];
            }
        }
        System.out.println("La ciudad de " + cityMax + " es la ciudad con la máxima temperatura anual: " + maxTemp + "ºC.");
        System.out.println("La ciudad de " + cityMin + " es la ciudad con la mínima temperatura anual: " + minTemp + "ºC.");
    }
}