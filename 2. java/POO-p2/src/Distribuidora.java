/*Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array con los datos
que quieras.
 */

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> stock = new ArrayList<Producto>();

        //CRACIÓN DE PRODUCTOS

        Perecedero prod1= new Perecedero("Pure", 10.0, 15);
        Perecedero prod2= new Perecedero("Queso", 30.0, 7);
        Perecedero prod3= new Perecedero("Leche", 50.0, 3);
        Perecedero prod4= new Perecedero("Tomate", 70.0, 2);
        Perecedero prod5= new Perecedero("Papa",40.0, 1);

        NoPerecedero prodA= new NoPerecedero("Fideo", 30.0, "pasta");
        NoPerecedero prodB= new NoPerecedero("Arroz", 60.0, "Legumbres");
        NoPerecedero prodC= new NoPerecedero("Porotos", 30.0, "Legumbres");
        NoPerecedero prodD= new NoPerecedero("Aceite", 150.8, "Aceites");
        NoPerecedero prodE= new NoPerecedero("Vino", 200, "Bebidas");

        //AGREGADO AL STOCK

        stock.add(prod1);
        stock.add(prod2);
        stock.add(prod3);
        stock.add(prod4);
        stock.add(prod5);
        stock.add(prodA);
        stock.add(prodB);
        stock.add(prodC);
        stock.add(prodD);
        stock.add(prodE);

        //COMPRA SIMULADA

        double totalTodo= 0.0;

        for (Producto p: stock){
            totalTodo += (double) Math.round(p.calcular(1)* 100d)/100d;
        }
        System.out.println("El stock total suma la cantidad de "+ totalTodo + " pesos");

        double totalAlgunos = (double)Math.round ((prod1.calcular(1)+ prodB.calcular(1)+
                prod4.calcular(1)+ prodC.calcular(1)+
                prodE.calcular(1))*100d)/100d;
        System.out.println("Los 5 productos elegidos suman el total de "+ totalAlgunos + " pesos");
    }
}