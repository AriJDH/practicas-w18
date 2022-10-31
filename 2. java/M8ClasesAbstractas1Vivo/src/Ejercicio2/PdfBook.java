package Ejercicio2;

public class PdfBook implements Printable {

    // Atributos
    private Integer numberOfPages;
    private String author;
    private String title;
    private String genre;

    // Constructor
    public PdfBook() {
    }

    public PdfBook(Integer numberOfPages, String author, String title, String genre) {
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    // Getters y setters

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    // To String


    @Override
    public String toString() {
        return "PDFBook{" +
                "numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
