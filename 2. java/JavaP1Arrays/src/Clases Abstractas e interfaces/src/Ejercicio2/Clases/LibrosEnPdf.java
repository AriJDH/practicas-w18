package Ejercicio2.Clases;

import Ejercicio2.Interfaces.IImprimir;
import Ejercicio2.Modelos.Libro;

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
