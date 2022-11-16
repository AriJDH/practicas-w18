package com.meli.lgutierrez.clase4.tarde.ejerciciosPracticos;

public class EjClaseAbsHija1 extends EjClaseAbsPadre <Integer>{

    private Integer valorInicial;
    private Integer valorSiguiente;
    private Integer valorSerie;

    public EjClaseAbsHija1() {
        valorInicial = 0;
        valorSerie = 0;
        valorSiguiente = 0;
    }

    @Override
    public Integer valorSiguiente() {
        if (valorInicial == 0) {
            valorSiguiente = valorSerie + valorSiguiente;
            return valorSiguiente;
        }else {
            valorSiguiente = valorInicial + valorSiguiente;
            valorInicial = 0;
            return valorSiguiente;
        }
    }

    @Override
    public Integer iniciarSerie(Integer valor) {
        valorSiguiente = 0;
        valorSerie = valor;
        valorSiguiente();
        return valorSerie;
    }

    @Override
    public void valorInicial(Integer valor) {
        valorSiguiente = 0;
        valorInicial = valor + valorSerie;
    }
}
