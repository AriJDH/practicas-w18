package Distribuidora;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        Perecedero prod1 = new Perecedero("Leche", 100.0, 3);
        productos.add(prod1);

        NoPerecedero prod2 = new NoPerecedero("Atun", 90.0, "Enlatados");
        productos.add(prod2);

        Producto prod3 = new Producto("Jabon", 75.0);
        productos.add(prod3);

        Perecedero prod4 = new Perecedero("Pan", 100.0, 1);
        productos.add(prod4);

        Perecedero prod5 = new Perecedero("Fiambre", 100.0, 7);
        productos.add(prod5);

        double total = 0;
        for(Producto p : productos){
            total += p.calcular(1);
        }

        System.out.println("Precio total: " + total);
    }
}
