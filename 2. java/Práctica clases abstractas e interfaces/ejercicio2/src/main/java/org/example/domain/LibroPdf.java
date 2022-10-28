package org.example.domain;

public class LibroPdf implements Imprimible{
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPdf(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public void print() {
        System.out.println("Cantidad de páginas: "+ this.cantidadPaginas);
        System.out.println("Autor: "+this.nombreAutor);
        System.out.println("Título: " + this.titulo);
        System.out.println("Género: " + this.genero);

    }
}
