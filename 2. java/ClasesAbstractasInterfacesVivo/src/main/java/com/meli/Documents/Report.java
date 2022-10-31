package com.meli.Documents;

import java.util.Arrays;

public class Report implements IPrint{

    private int n ;
    private char [] text;
    private int numberPages;
    private String autor;
    private String revisor;
    private static String TYPE_DOCUMENT= "Report";

    public Report(int n, int numberPages, String autor, String revisor) {
        this.n= n;
        this.text = new char[n];
        this.numberPages = numberPages;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void print() {
        System.out.println("Tipo de documento:" + TYPE_DOCUMENT);
        System.out.println("Detalle: " + this.toString());
    }

    @Override
    public String toString() {
        return "{" +
                "n=" + n +
                ", text=" + Arrays.toString(text) +
                ", numberPages=" + numberPages +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
