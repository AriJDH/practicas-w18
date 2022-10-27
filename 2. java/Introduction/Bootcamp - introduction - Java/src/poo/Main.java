package poo;
public class Main {
    public static void main(String... args) {
        Book book = new Book("League of legends", "Riot games", 5);
        System.out.println(book.showBook());
        System.out.println("Quantity of copies sold: " + book.quantityOfcopies());
    }
}
