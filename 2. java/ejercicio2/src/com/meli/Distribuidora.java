package com.meli;

import com.meli.domain.NoPerecedero;
import com.meli.domain.Perecedero;
import com.meli.domain.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> carrito = new ArrayList<Producto>();
        carrito.add(new Perecedero("Leche", 20, 1));
        carrito.add(new Perecedero("Queso", 30, 2));
        carrito.add(new Perecedero("Yogurt", 10, 3));
        carrito.add(new Perecedero("Jamóm", 40, 4));
        carrito.add(new Perecedero("Salame", 15, 5));
        carrito.add(new NoPerecedero("Arroz",20,"Cereales"));
        carrito.add(new NoPerecedero("Cereales",30,"Cereales"));
        carrito.add(new NoPerecedero("Pan",20,"Cereales"));
        carrito.add(new NoPerecedero("Caramelo",5,"Dulces"));
        carrito.add(new NoPerecedero("Agua",20,"Bebidas"));

        System.out.println("--------------------DATOS DE LOS PRODUCTOS DEL CARRITO--------------------");
        carrito.stream().forEach(prod-> System.out.println(prod.toString()));
        System.out.println("--------------------PRECIO TOTAL DEL CARRITO--------------------");
        System.out.println(carrito.stream().mapToDouble(prod->prod.calcular(5)).sum());;
    }
}
