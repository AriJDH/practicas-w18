package Ejercicio2.Interface;

public interface Printable {
    static <T>void printDocument(T t){
        System.out.println(t);
    };
}
