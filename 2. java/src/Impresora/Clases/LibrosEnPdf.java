package Impresora.Clases;

import Impresora.Interfaces.IImprimir;
import Impresora.Models.Libro;

public class LibrosEnPdf implements IImprimir<Libro> {
    public LibrosEnPdf() {
    }

    Libro libro;

    public LibrosEnPdf(Libro libro) {
        setLibro(libro);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public void imprimir() {
        System.out.println(getLibro());
    }
}