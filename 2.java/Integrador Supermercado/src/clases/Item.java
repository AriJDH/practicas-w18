package clases;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Item(String codigo, String nombre, int cantidad, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
