import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();

        Perecedero producto1 = new Perecedero("Leche",50.0,1);
        productos.add(producto1);
        Perecedero producto2 = new Perecedero("Tomate",150.0,2);
        productos.add(producto2);
        Perecedero producto3 = new Perecedero("Carne",1250.0,3);
        productos.add(producto3);
        NoPerecedero producto4 = new NoPerecedero("Fideos",60.0,"almacen");
        productos.add(producto4);
        NoPerecedero producto5 = new NoPerecedero("Azucar",70.0,"almacen");
        productos.add(producto5);
        //productos = Arrays.asList(producto1,producto2,producto3,producto4,producto5);
        double precioTotal = 0;

    //    precioTotal = precioTotal + productos.get(0).calcular(1);
        for (Producto producto : productos) {
            precioTotal = precioTotal + producto.calcular(1)  ;
        }
        System.out.println("El precio total es: " + precioTotal);

    }
}
