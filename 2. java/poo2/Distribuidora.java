import java.util.ArrayList;

public class Distribuidora {
    public static void main(String [] args){
        ArrayList<Producto> productos = new ArrayList<>();
        double total = 0;
        productos.add(new NoPerecedero("Azucar", 32.5, "A"));
        productos.add(new NoPerecedero("Frijol", 42, "B"));
        productos.add(new NoPerecedero("Miel", 72.5, "C"));
        productos.add(new Perecedero("Leche", 27.5,5));
        productos.add(new Perecedero("Yogurt", 11, 10));
        productos.add(new Perecedero("Gelatina", 8, 2));
        productos.add(new Perecedero("Crema", 17, 15));

        for(Producto producto : productos){
            total+=producto.calcular(5);
        }

        System.out.println("La suma de valor de 5 de cada producto es: "+total);
    }
}
