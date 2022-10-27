import Productos.NoPerecedero;
import Productos.Perecedero;
import Productos.Producto;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        double total = 0;
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche", 5, 4));
        productos.add(new Perecedero("Queso", 4, 1));
        productos.add(new Perecedero("Jamon", 3, 5));
        productos.add(new Perecedero("Manzana", 8, 2));
        productos.add(new Perecedero("Lechuga", 6, 10));
        productos.add(new Perecedero("Choclo", 4, 8));
        productos.add(new NoPerecedero("Arroz", 9, "A"));
        productos.add(new NoPerecedero("Azucar", 1, "A"));
        productos.add(new NoPerecedero("Miel", 6, "B"));
        productos.add(new NoPerecedero("Atun", 2, "B"));
        productos.add(new NoPerecedero("Fideos", 3, "C"));
        for (Producto producto: productos) {
            total += producto.calcular(5);
        }
        System.out.println("Suma de valor de 5 de cada producto: " + total);

    }
}
