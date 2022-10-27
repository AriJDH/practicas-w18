package ejercicio_poo_p2_vivo.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("shampoo", 1000, 1));
        productos.add(new NoPerecedero("jabon", 1000, "aseo"));
        productos.add(new Perecedero("cepillo", 1000, 1));
        productos.add(new NoPerecedero("crema dental", 1000, "aseo"));
        productos.add(new Perecedero("lavamanos", 1000, 2));

        double precioTotalProductos = 0;

        for (Producto producto : productos) {
            precioTotalProductos = precioTotalProductos + producto.calcular(3);
        }

        System.out.println("Precio total productos " + precioTotalProductos);
    }
}
