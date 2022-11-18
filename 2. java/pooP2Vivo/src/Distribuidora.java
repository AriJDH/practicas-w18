import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Producto1",2.5,1));
        productos.add(new Perecedero("Producto2",8.5,2));
        productos.add(new Perecedero("Producto3",10.0,3));
        productos.add(new Perecedero("Producto4",1.0,8));
        productos.add(new Perecedero("Producto5",2.0,1));

        productos.add(new NoPerecedero("Producto6",10.0,"tipo6"));
        productos.add(new NoPerecedero("Producto7",5.0,"tipo7"));
        productos.add(new NoPerecedero("Producto8",3.0,"tipo8"));
        productos.add(new NoPerecedero("Producto9",50.0,"tipo9"));
        productos.add(new NoPerecedero("Producto10",100.0,"tipo10"));

        System.out.println(productos.get(4).calcular(15));
        System.out.println(productos.get(5).calcular(2));

    }
}
