package com.meli.lgutierrez.clase3.ejercicioPractico2;

public class Informe implements TipoDocumento{
    private int logitudTexto;
    private int cantidadPaginas;
    private String nombreAutor;
    private String nombreRevisor;

    public Informe(int logitudTexto, int cantidadPaginas, String nombreAutor, String nombreRevisor) {
        this.logitudTexto = logitudTexto;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.nombreRevisor = nombreRevisor;
    }

    public int getLogitudTexto() {
        return logitudTexto;
    }

    public void setLogitudTexto(int logitudTexto) {
        this.logitudTexto = logitudTexto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    @Override
    public String toString() {
        return "------Imprimiendo informe------ \n" +
                "Logitud del texto: " + logitudTexto +
                "\nCantidad de páginas: " + cantidadPaginas +
                "\nNombre del autor: '" + nombreAutor +
                "\nNombre del revisor: '" + nombreRevisor +"\n";
    }
}
