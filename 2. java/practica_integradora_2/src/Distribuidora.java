import java.util.ArrayList;

public class Distribuidora {
    private ArrayList<Producto> productos;

    public Distribuidora() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
            this.productos.add(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double calcularTotalVenta(){
        double total = 0;
        for (Producto prd: productos ) {
            total += prd.calcular(5);
        }
        return total;
    }
}