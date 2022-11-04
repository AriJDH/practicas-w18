package clases;

public class Producto {
    private String codigo;
    private String nombre;
    private int contidadComprado;
    private double costoUnitario;

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

    public int getContidadComprado() {
        return contidadComprado;
    }

    public void setContidadComprado(int contidadComprado) {
        this.contidadComprado = contidadComprado;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Producto() {}

    public Producto(String codigo, String nombre, int contidadComprado, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.contidadComprado = contidadComprado;
        this.costoUnitario = costoUnitario;
    }
}
