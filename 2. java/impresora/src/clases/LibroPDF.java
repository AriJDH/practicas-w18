package clases;

import Interface.Imprimible;
import superclase.Archivo;

public class LibroPDF extends Archivo implements Imprimible {

    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }
}
