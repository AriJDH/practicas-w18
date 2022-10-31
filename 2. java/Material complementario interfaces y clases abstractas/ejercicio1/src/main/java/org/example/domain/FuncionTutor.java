package org.example.domain;

public interface FuncionTutor {
    default void darTutoria(){
        System.out.println("Yo doy tutorias");
    }
}
