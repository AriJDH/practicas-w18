package Ejercicio2.modal;

import Ejercicio2.Interface.Printable;

public class BookPDF implements Printable {
    private int page;
    private String authorName;
    private String title;

    public BookPDF(int page, String authorName, String title) {
        this.page = page;
        this.authorName = authorName;
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookPDF{" +
                "page=" + page +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
