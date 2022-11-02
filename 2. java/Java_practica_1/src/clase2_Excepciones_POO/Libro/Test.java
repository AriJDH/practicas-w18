package clase2_Excepciones_POO.Libro;

public class Test {
    public static void main(String[] args) {
        Libro libro = new Libro("Harry Potter", "J. K. Rowling", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este libro es de: " + libro.cantidadDeEjemplares());
    }
}
