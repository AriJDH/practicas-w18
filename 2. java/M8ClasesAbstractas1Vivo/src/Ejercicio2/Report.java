package Ejercicio2;

public class Report  implements Printable {

    // Atributos
    private String text; // TODO limitar la cantidad de caracteres
    private Integer numberOfPages;
    private String author;
    private String reviewer;

    // Constructores
    public Report() {
    }

    public Report(String text,
                  Integer numberOfPages,
                  String author,
                  String reviewer) {
        this.text = text;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.reviewer = reviewer;
    }

    // Getters y setters

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

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

    public String getRevisor() {
        return reviewer;
    }

    public void setRevisor(String reviewer) {
        this.reviewer = reviewer;
    }

    // To String


    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
