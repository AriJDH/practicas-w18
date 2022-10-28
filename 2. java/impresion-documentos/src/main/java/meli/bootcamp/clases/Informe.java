package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Impresable;

public class Informe implements Impresable {
    private String contenido;
    private int cantPaginas;
    private Persona autor;
    private Persona revisor;

    @Override
    public void imprimirDocumento() {
        System.out.println("Documento impreso");
    }
}
