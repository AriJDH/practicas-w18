package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

public class Item {
    private String codigo;
    private String nombre;
    private int cantComprada;
    private Double precioUnitario;

    public Item(String codigo, String nombre, int cantComprada, Double precioUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.precioUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
