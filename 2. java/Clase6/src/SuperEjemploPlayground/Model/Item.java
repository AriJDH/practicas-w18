package SuperEjemploPlayground.Model;

public class Item {
    private Long codigoItem;
    private String nombre;
    private double precio;
    private int cantidad;

    public Item(Long codigoItem, String nombre, double precio, int cantidad) {
        this.codigoItem = codigoItem;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
