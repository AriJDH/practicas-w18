package clases;

public class Producto {
    private static int siguienteCodigo = 1;

    private String nombre;
    private int codigo;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = siguienteCodigo;
        siguienteCodigo++;
    }

    public static int getSiguienteCodigo() {
        return siguienteCodigo;
    }

    public static void setSiguienteCodigo(int siguienteCodigo) {
        Producto.siguienteCodigo = siguienteCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
