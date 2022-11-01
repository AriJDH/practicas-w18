package Ejercicio2;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("P1",4.5,1));
        productos.add(new Perecedero("P2",3.5,2));
        productos.add(new Perecedero("P3",2.5,3));
        productos.add(new Perecedero("P4",5.5,1));
        productos.add(new Perecedero("P5",4.5,2));

        productos.add(new NoPerecedero("NP1",4.5,"x"));
        productos.add(new NoPerecedero("NP2",3.5,"x"));
        productos.add(new NoPerecedero("NP3",2.5,"x"));
        productos.add(new NoPerecedero("NP4",1.5,"x"));
        productos.add(new NoPerecedero("NP5",5.5,"x"));


        for(Producto p : productos){
            System.out.println(p.calcular(2));
        }

    }
}
