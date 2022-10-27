package com.company;

public class Distribuidora {
    public static void main(String[] args){
        Producto productos[] = new Producto[5];
        productos[0] = new Perecedero2("Leche",1000,3);
        productos[1] = new Perecedero2("Pan",2000,10);
        productos[2] = new NoPerecedero("Frijoles", 5000, "Enlatado" );
        productos[3] =  new NoPerecedero("Maiz", 4000, "Enlatado" );
        productos[4] = new Perecedero2("Tomate",400,1);

        for(Producto p:productos){
            System.out.println("5 unidades de "+ p.getNombre()+" Cuestan "+p.calcular(5));
        }

    }
}
