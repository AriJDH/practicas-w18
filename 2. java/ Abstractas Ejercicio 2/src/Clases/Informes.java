package Clases;

import Interfaz.Impresion;

public class Informes implements Impresion {
    private String texto;
    private int cantidadPagina;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantidadPagina, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPagina = cantidadPagina;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String imprimir() {
        return "Imprimiendo el informe con numero de páginas: " + cantidadPagina +"\n" +" Autor: "+ autor +"\n" +" Revisor "+revisor
                +"\n" + texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPagina() {
        return cantidadPagina;
    }

    public void setCantidadPagina(int cantidadPagina) {
        this.cantidadPagina = cantidadPagina;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
}
