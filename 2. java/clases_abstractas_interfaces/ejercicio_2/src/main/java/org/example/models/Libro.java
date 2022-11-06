package org.example.models;

public class Libro implements Imprimible{

    private String author;
    private String title;
    private String genre;
    private int numberOfPages;

    public Libro(String author, String title, String genre, int numberOfPages) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "El libro " + title + " es del autor/a " + author + " del género " + genre + " y tiene " + numberOfPages + " de páginas.";
    }
}
