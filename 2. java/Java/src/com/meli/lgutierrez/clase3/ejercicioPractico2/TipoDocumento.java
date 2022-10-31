package com.meli.lgutierrez.clase3.ejercicioPractico2;

public interface TipoDocumento <T>{

    default void imprimir(T t){
        System.out.println(t.toString());
    }
}
