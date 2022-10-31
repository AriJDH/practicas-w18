package com.meli.Documents;

public class PdfBook implements IPrint{
    private int pages;
    private String autor;
    private String title;
    private String gender;
    private static String TYPE_DOCUMENT= "PdfBook";

    public PdfBook(int pages, String autor, String title, String gender) {
        this.pages = pages;
        this.autor = autor;
        this.title = title;
        this.gender = gender;
    }

    @Override
    public void print() {
        System.out.println("Tipo de documento:" + TYPE_DOCUMENT);
        System.out.println("Detalle: " + this.toString());
    }

    @Override
    public String toString() {
        return "{" +
                "pages=" + pages +
                ", autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
