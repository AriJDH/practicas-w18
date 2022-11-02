package Paquete;

import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        Producto productos[] = new Producto[6];
        double total=0;

        //Productos perecederos
        productos[0] = new Perecedero("Papitas", 16000, 2);
        productos[1] = new Perecedero("Pollito", 38000, 3);
        productos[2]= new Perecedero("Quesito", 16000, 3);

        //Productos no perecederos
        productos[3] = new NoPerecedero("Atún", 5800, "Enlatado");
        productos[4] = new NoPerecedero("Pastas", 4200, "En bolsa");
        productos[5] = new NoPerecedero("Cafesito", 7500, "En polvo");

        System.out.println("---------------");  //Comprara 5 productos de cada uno
        System.out.println("Factura");
        for (int i=0;i<productos.length;i++){ //Todos los de la lista
            System.out.println(" ");
            System.out.println("Producto "+ i +":");
            System.out.println(productos[i].toString());
            System.out.println("Su precio queda en: " + productos[i].calcular(5) );
            System.out.println("Cantidad a comprar: 5");
            System.out.println(" ");
            total=total+ productos[i].calcular(5); //5 productos
        }
        System.out.println(" ");
        System.out.println("---------------");
        System.out.println("El total a pagar es: " + total);


    }
}

