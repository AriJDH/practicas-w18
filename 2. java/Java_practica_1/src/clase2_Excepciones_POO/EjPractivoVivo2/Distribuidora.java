package clase2_Excepciones_POO.EjPractivoVivo2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
//        Perecedero pere = new Perecedero("fideos",100,2);
//        System.out.println("El precio final es: $" + pere.calcular(3));

        List<Producto> vProductos = new ArrayList<Producto>();
        Producto prod1 = new Producto("arroz",130.20);
        Producto prod2 = new Producto("fideos",200.40);
        Producto prod3 = new Producto("harina",89.40);
        Producto prod4 = new Producto("yerba",98.50);
        Producto prod5 = new Producto("cafe",230.35);

        vProductos.add(prod1);
        vProductos.add(prod2);
        vProductos.add(prod3);
        vProductos.add(prod4);
        vProductos.add(prod5);

        double precioFinal = 0;
        for ( Producto elemento : vProductos ){
            System.out.println(elemento.toString());
            precioFinal += elemento.calcular(5);
            System.out.println(elemento.calcular(5));
        }
        System.out.println("El precio final de la venta de los productos: " + precioFinal);
    }
}
