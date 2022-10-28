package com.main;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();

        productos.add(new Perecedero("Carne", 30d, 5));
        productos.add(new Perecedero("Queso", 20d, 5));
        productos.add(new Perecedero("Manteca", 10d, 5));
        productos.add(new Perecedero("Leche", 7d, 5));
        productos.add(new Perecedero("Yogur", 5d, 5));

        productos.add(new NoPerecedero("Frijol", 30d, "Legumbre"));
        productos.add(new NoPerecedero("Arroz", 20d, "Cereal"));
        productos.add(new NoPerecedero("Polenta", 10d, "Polenta"));
        productos.add(new NoPerecedero("Miel", 7d, "Miel"));
        productos.add(new NoPerecedero("Harina", 5d, "Harina"));

        double total = 0;

        for (Producto item : productos) {

            total += item.calcular(5);
            System.out.println(item.getNombre() + " " + item.calcular(5));
        }

        System.out.println("----------------");
        System.out.println("FINAL : " + total);
    }
}
