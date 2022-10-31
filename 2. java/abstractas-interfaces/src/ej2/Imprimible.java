package ej2;

public interface Imprimible {
    static void imprimir(Documento d) {
        System.out.println(d.toString());
    }
}
