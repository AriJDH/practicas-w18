import Clases.NoPerecedero;
import Clases.Perecedero;
import Clases.Producto;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        Perecedero perecedero = new Perecedero("Pepsi", 200, 2);
        NoPerecedero noPerecedero = new NoPerecedero("Fanta", 175, "Bebida");

        double sum = 0;
        ArrayList<Producto> list = new ArrayList();
        list.add(perecedero);
        list.add(noPerecedero);

        for (Producto item : list){
            sum += item.calcular(5);
        }
        System.out.println("Total de los 10 productos: $" + sum);

    }
}