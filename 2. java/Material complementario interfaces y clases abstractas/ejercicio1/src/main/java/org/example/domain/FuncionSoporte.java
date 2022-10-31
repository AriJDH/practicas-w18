package org.example.domain;

public interface FuncionSoporte {
    default void darSoporte(){
        System.out.println("Yo doy soporte");
    }
}
