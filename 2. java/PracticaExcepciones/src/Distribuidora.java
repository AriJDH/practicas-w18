import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> arrayProductos = new ArrayList<Producto>();
        Producto p1 = new Producto("arroz",90);
        Producto p2 = new Producto("fideos",110);
        Producto p3 = new Producto("leche",80);
        Producto p4 = new Producto("huevos",190);

        arrayProductos.add(p1);
        arrayProductos.add(p2);
        arrayProductos.add(p3);
        arrayProductos.add(p4);

        double precioFinal=0;
        for(Producto prod : arrayProductos){

            precioFinal += prod.calcular(5);

        }
        System.out.println("El precio final de vender 5 productos de cada tipo es: $" + precioFinal);

    }
}