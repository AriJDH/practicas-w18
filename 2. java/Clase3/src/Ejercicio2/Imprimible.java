package Ejercicio2;

public interface Imprimible {

    void imprimirDocumentos();

    static void imprimir(Imprimible imp){
        imp.imprimirDocumentos();
    }
}
