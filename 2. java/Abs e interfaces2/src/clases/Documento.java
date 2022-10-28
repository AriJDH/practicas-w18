package clases;

import interfaces.Imprimible;

public abstract class Documento implements Imprimible {
    @Override
    public void imprimir(Documento documento) {
        System.out.println("Estoy imprimiendo un " + documento.getClass().getSimpleName());
    }
}
