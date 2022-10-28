package org.example.domain;

public class Informe implements Imprimible{
    private String texto;
    private int cantidadPaginas;
    private String nombreAutor;
    private String nombreRevisor;

    public Informe(String texto, int cantidadPaginas, String nombreAutor, String nombreRevisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public void print() {
        System.out.println("Texto: " + this.texto);
        System.out.println("Cantidad de páginas: " + this.cantidadPaginas);
        System.out.println("Autor: " + this.nombreAutor);
        System.out.println("Revisor: " + nombreRevisor);
    }
}
