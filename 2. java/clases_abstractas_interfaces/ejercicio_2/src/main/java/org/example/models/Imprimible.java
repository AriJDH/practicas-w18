package org.example.models;

public interface Imprimible {

    static <T>void print(T t) {
        System.out.println(t);
    }
}
