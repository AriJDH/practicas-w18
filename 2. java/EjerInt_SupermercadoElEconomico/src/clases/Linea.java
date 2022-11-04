package clases;

public class Linea {
    private Producto producto;
    private int cantidad;

    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double obtenerSubtotalLinea(){
        return this.cantidad * this.producto.getPrecio();
    }
}
