package com.meli;

import com.meli.ClasesAbstractas.Series;

public class Main {
    public static void main(String[] args) {
        Series serie = new Series(2,2);
        System.out.println("=============================");
        System.out.println("SERIE 1:");
        System.out.println(serie.getValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println("=============================");
        serie.setValue(1);
        serie.setIncrement(2);
        System.out.println("=============================");
        System.out.println("SERIE 2:");
        System.out.println(serie.getValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println("=============================");
        serie.setValue(3);
        serie.setIncrement(3);
        System.out.println("=============================");
        System.out.println("SERIE 3:");
        System.out.println(serie.getValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println(serie.getNextValue());
        System.out.println("=============================");

    }
}