package distribuidoraProductos;

import java.util.ArrayList;
import java.util.Scanner;

public class  Distribuidora {
    public static void main(String[] args) {
        //Variable
        double precioTotal=0 ;

        //Lista de productos
        ArrayList<Producto> listaProductos = new ArrayList<>();

        //Creo los productos
        NoPerecedero leche = new NoPerecedero("leche",3000,"No perecedero ");
        NoPerecedero arroz = new NoPerecedero("arroz",3500,"No perecedero ");
        NoPerecedero chocolate = new NoPerecedero("chocolate",4000,"No perecedero ");
        NoPerecedero aceite = new NoPerecedero("aceite",4000,"No perecedero");

        Perecedero tomate = new Perecedero("tomate",4000,1);
        Perecedero cebolla = new Perecedero("cebolla",4000,2);
        Perecedero platano = new Perecedero("platano",4000,3);

        //Diligencio la lista de productos
        listaProductos.add(leche);
        listaProductos.add(arroz);
        listaProductos.add(chocolate);
        listaProductos.add(aceite);
        listaProductos.add(tomate);
        listaProductos.add(cebolla);

        //Solicito cantidad por elemento
        System.out.println("Ingrese la cantidad de elementos según corresponda ");
        System.out.println("Leche");
        Scanner c =new Scanner(System.in);
        int cl=c.nextInt();
        System.out.println("Arroz");
        int ca=c.nextInt();
        System.out.println("Chocolate");
        int ch=c.nextInt();
        System.out.println("Aceite");
        int ac=c.nextInt();
        System.out.println("Cebolla");
        int ce=c.nextInt();
        System.out.println("Tomate");
        int to=c.nextInt();
        System.out.println("Platano");
        int pl=c.nextInt();



        for (Producto l :listaProductos) {
             precioTotal = leche.calcular(cl)+ arroz.calcular(ca)+ chocolate.calcular(ch)+ aceite.calcular(ac)+ cebolla.calcular(ce)+tomate.calcular(to)+ platano.calcular(pl);
        }

        System.out.println("El precio total es: " + precioTotal);









    }
}
