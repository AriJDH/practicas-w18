package org.example.domain;

public interface Carnivoro {
    default void comerCarne(){
        System.out.println("AAAAAA YO COMO CARNEEEE DAME UN BIFE");
    }
}
