package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioProductos {
    List<Producto> productos = new ArrayList<>();

    public RepositorioProductos(Producto producto) {
        productos.add(producto);
    }

    public RepositorioProductos() {
    }
    public List<Producto> getProductos() {
        return productos;
    }

    public void cargarProductos(Producto producto) {
        productos.add(producto);
    }
}
