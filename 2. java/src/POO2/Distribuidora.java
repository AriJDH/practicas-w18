package POO2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args){
        ArrayList<Producto> productoArrayList = new ArrayList<Producto>();
        productoArrayList.add(new Perecedero("Carne",200,20));
        productoArrayList.add(new Perecedero("Yogurt",100,10));
        productoArrayList.add(new Perecedero("Pan",50,3));
        productoArrayList.add(new NoPerecedero("Arroz",300,"procesado"));
        productoArrayList.add(new NoPerecedero("polenta",230,"no procesado"));

        double precioTotal = 0;
        for (Producto prod : productoArrayList) {
            precioTotal += prod.calcular(5);
        }
        System.out.printf(String.valueOf(precioTotal));
    }
}
