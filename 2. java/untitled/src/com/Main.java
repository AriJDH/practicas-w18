package com;

public class Main {
    public static void main(String[] args) {
        int temperaturas[][] = {
                {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}
        };
        String ciudades[] = {"Londres", "Madrid", "New York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "tokio"};

        String ciudad_minima = "";
        String ciudad_maxima = "";
        int minima = 1000;
        int maxima = 0;

        for (int i = 0; i < ciudades.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (temperaturas[i][j] < minima) {
                    minima = temperaturas[i][j];
                    ciudad_minima = ciudades[i];
                }
                if (temperaturas[i][j] > maxima) {
                    maxima = temperaturas[i][j];
                    ciudad_maxima = ciudades[i];
                }
            }
        }
        System.out.println("la temperatura mínima es..:" + minima + " en la ciudad..:" + ciudad_minima);
        System.out.println("la temperatura máxima es..:" + maxima + " en la ciudad..:" + ciudad_maxima);
    }
}