package org.example;

import domain.SerieArimetica;
import domain.SerieGeometrica;

public class Main {
    public static void main(String[] args) {

        System.out.println("PRIMEROS 5 VALORES DE SERIE GEOMÉTRICA RAZON 2 Y VALOR INICIAL 1");
        SerieGeometrica serieGeometrica = new SerieGeometrica(1,2);
        for(int i=0; i<5; i++){
            System.out.println(serieGeometrica.next());
        }

        System.out.println("PRIMEROS 5 VALORES DE SERIE ARITMÉTICA RAZON 2 Y VALOR INICIAL 1");
        SerieArimetica serieArimetica = new SerieArimetica(1,2);
        for(int i=0; i<5; i++){
            System.out.println(serieArimetica.next());
        }
    }
}