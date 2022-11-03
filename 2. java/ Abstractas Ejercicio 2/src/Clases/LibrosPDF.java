package Clases;

import Interfaz.Impresion;

public class LibrosPDF implements Impresion {
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibrosPDF(int cantidadPaginas, String autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String imprimir() {
        return "Imprimiento el libro en PDF "+ titulo+ "\n" +" Páginas: " + cantidadPaginas +"\n" +" Autor: " + autor + "Genero: "+ genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
