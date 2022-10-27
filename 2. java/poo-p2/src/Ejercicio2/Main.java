package Ejercicio2;

public class Main {

    public static void main(String[] args) {

        Producto producto = new Producto("Coca-cola", 1500);
        System.out.println(producto);
        System.out.println(producto.calcular(2));

        Perecedero perecedero = new Perecedero("Leche", 2000, 2);
        System.out.println(perecedero);
        System.out.println(perecedero.calcular(2));
    }
}
