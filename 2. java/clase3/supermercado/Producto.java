package clase3.supermercado;

public class Producto {

    private int codigo;
    private String nombre;
    private int cant;
    private double precioUnitario;

    public Producto(int codigo, String nombre, int cant, double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.precioUnitario = precioUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
