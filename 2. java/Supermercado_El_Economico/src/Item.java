public class Item {

    private int codigo;
    private String nombre;
    private int cantidad;
    private double costo_unitario;


    public Item(int codigo, String nombre, int cantidad, double costo_unitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo_unitario = costo_unitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCosto_unitario() {
        return costo_unitario;
    }
}
