package POO_Parte2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] listaProductos = new Producto[4];
        listaProductos[0] = new Perecedero("Leche", 100, 1);
        listaProductos[1] = new Perecedero("Jugo", 50, 2);
        listaProductos[2] = new NoPerecedero("Silla", 3000, "Mueble");
        listaProductos[3] = new NoPerecedero("Heladera", 100000, "Electrodomestico");

        for (Producto p: listaProductos) {
            System.out.println(p);
            System.out.println("$"+p.calcular(5));
        }
    }
}
