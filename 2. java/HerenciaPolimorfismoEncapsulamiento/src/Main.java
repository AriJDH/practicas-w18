import Logica.Distribuidora;
import Logica.Producto;

public class Main {

    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();
        Producto []listProducts = distribuidora.getListProducts();

        for(Producto producto: listProducts){
            System.out.println(producto + " " + producto.getNombre() + " precio: " + String.format("%.2f",producto.getPrecio()));
            int cantidadProductos = (int) Math.round(Math.random()*9+1);
            System.out.println(cantidadProductos + " unidades valen " + String.format("%.2f", producto.calcular(cantidadProductos)));
        }
    }
}
