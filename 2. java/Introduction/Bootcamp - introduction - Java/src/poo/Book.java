package poo;

public class Book {
  String title;
  String author;
  int copies;

  public Book(String title, String author, int copies) {
    this.title = title;
    this.author = author;
    this.copies = copies;
  }

  public int quantityOfcopies() {
    return this.copies;
  }

  public String showBook() {
    return (
      "Title: " +
      this.title +
      " Author: " +
      this.author +
      " Copies: " +
      this.copies
    );
  }
}
