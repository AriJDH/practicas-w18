package clases;

public class ItemsPorFactura {
    private Integer cantidad;
    private Producto producto;
    private double precioUnitario;
    private double subTotal;

    public ItemsPorFactura(Integer cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.precioUnitario = producto.getCostoUnitario();
        this.subTotal = cantidad * precioUnitario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getSubTotal() {
        return subTotal;
    }
}
