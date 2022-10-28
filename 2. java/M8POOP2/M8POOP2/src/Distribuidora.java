import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<Producto>();

        Perecederos producto1 = new Perecederos("Leche",50,1);
        productos.add(producto1);
        Perecederos producto2 = new Perecederos("Tomate",150,2);
        productos.add(producto2);
        Perecederos producto3 = new Perecederos("Carne",1250,3);
        productos.add(producto3);
        NoPerecederos producto4 = new NoPerecederos("Fideos",60,"almacen");
        productos.add(producto4);
        NoPerecederos producto5 = new NoPerecederos("Azucar",70,"almacen");
        productos.add(producto5);
        // productos = Arrays.asList(producto1,producto2,producto3,producto4,producto5);
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal = precioTotal + producto.calcular(1)  ;
        }
        System.out.println("El precio total es: " + precioTotal);
    }
}
