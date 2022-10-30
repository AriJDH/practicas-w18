package herencia;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] listaProductos = new Producto[4];
        listaProductos[0] = new Perecedero("Leche", 20, 2);
        listaProductos[1] = new Perecedero("Mayonesa", 30, 1);
        listaProductos[2] = new NoPerecedero("Mesa", 3000, "Mueble");
        listaProductos[3] = new NoPerecedero("Cocina", 100000, "Electrodomestico");

        for (Producto p: listaProductos) {
            System.out.println(p);
            System.out.println("$"+p.calcular(5));
            System.out.println();
        }

    }
}
