package org.example.models;

public class Informe implements Imprimible{

    private String author;
    private int numberOfPages;
    private String editor;
    private String text;

    public Informe(String author, int numberOfPages, String editor, String text) {
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.editor = editor;
        this.text = text;
    }

    @Override
    public String toString() {
        return "El informe del autor " + author + " contiene " + numberOfPages + " números de páginas y fue revisado por " + editor + ".\n" + "Breve descripción: " + text;
    }
}
