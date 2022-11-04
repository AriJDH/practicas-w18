package Poo;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<Producto>();

        productos.add( new Perecedero("Huevos", 15000, 5));
        productos.add( new Perecedero("Pollo", 30000, 4));
        productos.add( new Perecedero("Carne Res", 17800, 3));
        productos.add( new Perecedero("Carne Cerdo", 15600, 2));
        productos.add( new Perecedero("Yogur", 1500, 1));
        productos.add( new NoPerecedero("Frijol en lata", 15000, "A"));
        productos.add( new NoPerecedero("Atún", 15000, "B"));
        productos.add( new NoPerecedero("Salchichas en lata", 15000,"A"));
        productos.add( new NoPerecedero("Champiñones en lata", 15000, "B"));
        productos.add( new NoPerecedero("Sardina en lata", 15000, "C"));

        double total = 0;

        for (Producto producto: productos) {
            total += producto.calcular(5);
        }
        System.out.println("Precio total venta "+ total);
    }

}
