package com.meli.lgutierrez.clase4.tarde.ejerciciosPracticos;

public class EjClaseAbsMain {
    public static void main(String[] args) {
        EjClaseAbsPadre serie = new EjClaseAbsHija1();

        System.out.println(serie.iniciarSerie(2));
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());

        System.out.println("-----");
        serie.valorInicial(1);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());

        System.out.println("-----");
        System.out.println(serie.iniciarSerie(3));
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());


    }
}
