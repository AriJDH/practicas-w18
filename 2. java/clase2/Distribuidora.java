package clase2;

import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList <Producto> productos = new ArrayList<>();
        Perecedero p1 = new Perecedero();
        p1.setNombre("Coca Cola");
        p1.setPrecio(10);
        p1.setDiasPorCaducar(1);
        productos.add(p1);
        

        Perecedero p2 = new Perecedero();
        p2.setNombre("Pepsi");
        p2.setPrecio(10);
        p2.setDiasPorCaducar(2);
        productos.add(p2);

        NoPerecedero p3 = new NoPerecedero();
        p3.setNombre("Cerveza");
        p3.setPrecio(10);
        p3.setTipo("Alcohol");
        productos.add(p3);

        NoPerecedero p4 = new NoPerecedero();
        p4.setNombre("Galletas");
        p4.setPrecio(10);
        p4.setTipo("Comida");

        // calcular el precio de cada producto
        for (Producto p : productos) {
            p.calcular(10);
            System.out.println(p);
        }
    }
}
