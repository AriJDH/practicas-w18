package Supermercado;

public class Item {
    private long codigoItem;
    private String nombre;
    private double precio;
    private int cantidad;

    public Item(long codigoItem, String nombre, double precio, int cantidad) {
        this.codigoItem = codigoItem;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public long getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(long codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigoItem=" + codigoItem +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
