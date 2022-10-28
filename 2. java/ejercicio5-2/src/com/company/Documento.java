package com.company;

public class Documento implements Imprime {

    @Override
    public void imprimible(String documento) {
        System.out.println("Documento tipo: " + documento);
    }
}
