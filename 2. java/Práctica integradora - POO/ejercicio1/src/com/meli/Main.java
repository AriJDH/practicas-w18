package com.meli;

import com.meli.domain.PracticaExcepciones;

public class Main {

    public static void main(String[] args) {
        try{
            (new PracticaExcepciones()).calcularCociente();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
