package ejercicio2_Imprimir.Model;

import ejercicio2_Imprimir.Interfaz.Printable;

public class BookPDF implements Printable {
    private int numberOfPages;
    private String authorName;
    private String title;
    private String gender;

    public BookPDF() {
    }

    public BookPDF(int numberOfPages, String authorName, String title, String gender) {
        this.numberOfPages = numberOfPages;
        this.authorName = authorName;
        this.title = title;
        this.gender = gender;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "LibroPDF\t{ " +
                "Número de Páginas:" + numberOfPages +
                ", Autor: " + authorName +
                ", Título: " + title +
                ", Género: " + gender +
                '}';
    }
}
