package ejercicio2_Imprimir.Model;

import ejercicio2_Imprimir.Interfaz.Printable;

public class Report implements Printable {
    private int length;
    private int numberOfPages;
    private String author;
    private String reviewer;

    public Report() {
    }

    public Report(int length, int numberOfPages, String author, String reviewer) {
        this.length = length;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Informe \t{ " +
                " Longitud del Texto: " + length +
                ", Número de páginas: " + numberOfPages +
                ", Autor: " + author +
                ", Revisor: " + reviewer +
                '}';
    }
}
