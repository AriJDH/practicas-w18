package meli.bootcamp.clases;

import meli.bootcamp.interfaces.Impresable;

import java.util.ArrayList;

public class Libro implements Impresable {
    private Persona autor;
    private int cantPaginas;
    private String titulo;
    private ArrayList<String> generos;

    @Override
    public void imprimirDocumento() {
        System.out.println("Documento impreso");
    }
}
