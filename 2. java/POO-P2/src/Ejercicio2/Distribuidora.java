package Ejercicio2;
//EJERCICIO 2

// 4.
public class Distribuidora {

    public static void main(String[] args){

        Producto[] productos= new Producto[10];

        productos[0]= new Perecedero("Yogurt 1L", 280,5);
        productos[1]= new Perecedero("Levadura fresca", 60, 2);
        productos[2]= new Perecedero("Leche liquida",130,1 );
        productos[3]= new Perecedero("Yogurt 90grs",90,3);
        productos[4]= new Perecedero("Flan 90grs",110,6);
        productos[5]= new NoPerecedero("Arroz",110,"Alimento");
        productos[6]= new NoPerecedero("Fideo",130,"Alimento");
        productos[7]= new NoPerecedero("Polenta", 80,"Alimento");
        productos[8]= new NoPerecedero("Papel higienico",300,"Limpieza");
        productos[9]= new NoPerecedero("Servilleta",250,"Cocina");


        System.out.println("Precio total de productos perecederos: ");
        double totalPerecedero=0;
        for (int i=0; i<5; i++){
            totalPerecedero=+productos[i].calcular(5);
        }
        System.out.println(totalPerecedero);

        System.out.println("Precio total de productos No perecederos: ");
        double totalNoPerecedero=0;
        for (int i=5; i<10; i++){
            totalNoPerecedero=+productos[i].calcular(5);
        }
        System.out.println(totalNoPerecedero);
    }
}
