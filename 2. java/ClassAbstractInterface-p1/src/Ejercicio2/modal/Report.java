package Ejercicio2.modal;

import Ejercicio2.Interface.Printable;

public class Report implements Printable {
    private String text;
    private String authorName;
    private String reviewerName;
    private int page;

    public Report(String text, String authorName, String reviewerName, int page) {
        this.text = text;
        this.authorName = authorName;
        this.reviewerName = reviewerName;
        this.page = page;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", authorName='" + authorName + '\'' +
                ", reviewerName='" + reviewerName + '\'' +
                ", page=" + page +
                '}';
    }
}
