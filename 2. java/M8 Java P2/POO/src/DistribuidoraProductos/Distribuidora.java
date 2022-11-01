package DistribuidoraProductos;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {


        ArrayList<Producto> productos = new ArrayList<>();

        Producto perecedero1 = new Perecedero("Leche", 10d, 10);
        Producto perecedero2 = new Perecedero("Pan", 10d, 10);
        Producto noPerecedero3 = new NoPerecedero("Lenteja", 10d, "Lata");
        Producto noPerecedero4 = new NoPerecedero("Harina", 10d, "Paquete");
        Producto perecedero5 = new Perecedero("Crema", 10d, 10);

        productos.add(perecedero1);
        productos.add(perecedero2);
        productos.add(noPerecedero3);
        productos.add(noPerecedero4);
        productos.add(perecedero5);


        double sumaPerecedero = 0;
        double sumaNoPerecedero = 0;
        double totalCompra = 0;

        for (Producto p : productos) {

            mostrarProductos(p, 5);
            if (p instanceof Perecedero) {
                System.out.println("Producto Perecedero > Días por caducar: " + ((Perecedero) p).getDiasPorCaducar());
                sumaPerecedero += p.calcular(5);
                mostrarSuma("Parcial", p.getClass(), sumaPerecedero);
            } else {
                System.out.println("Producto no perecedero");
                sumaNoPerecedero += p.calcular(5);
                mostrarSuma("Parcial", p.getClass(), sumaNoPerecedero);

            }

            totalCompra = sumaPerecedero + sumaNoPerecedero;
        }


        System.out.println("--- ");

        mostrarSuma("Total", Perecedero.class, sumaPerecedero);
        mostrarSuma("Total", NoPerecedero.class, sumaNoPerecedero);

        System.out.println("------------------------------ TOTAL $" + totalCompra);
    }

    public static void mostrarProductos(Producto p, int cantidad){
        System.out.println("---");
        System.out.println(p.getNombre() + " $"  + p.getPrecio() + " c/u" + " - Total $" + p.calcular(cantidad));
    }

    public static void mostrarSuma(String tipo, Class<? extends Producto> aClass, double suma){
        System.out.println( tipo + " Categoría: " + aClass.getSimpleName() + " $" + suma);
    }


}
