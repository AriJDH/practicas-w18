package com.meli.lgutierrez.clase2.tarde.ejercicoClase;

public class Distribuidora {

    public static void main(String[] args) {
        Producto queso = new Perecedero("queso", 15000, 5);
        Producto yogurt = new Perecedero("yogurt", 12500, 2);
        Producto jabon = new NoPerecedero("jabon", 5200, "aseo");
        Producto chocolate = new NoPerecedero("chocolate", 6500, "comida");
        Producto cafe = new NoPerecedero("café", 6500, "comida");

        Producto productos[] = new Producto[5];

        productos[0] = queso;
        productos[1] = yogurt;
        productos[2] = jabon;
        productos[3] = chocolate;
        productos[4] = cafe;

        double precioTotal = 0;

        for (Producto producto : productos) {
            precioTotal += producto.calcular(1);
        }

        System.out.println("El precio total de la compra es de: $" + Math.round(precioTotal));
    }
}
