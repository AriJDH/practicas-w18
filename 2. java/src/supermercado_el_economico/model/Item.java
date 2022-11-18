package supermercado_el_economico.model;

public class Item {

    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnd;

    public Item(String codigo, String nombre, int cantidadComprada, double costoUnd) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnd = costoUnd;
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

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnd() {
        return costoUnd;
    }

    public void setCostoUnd(double costoUnd) {
        this.costoUnd = costoUnd;
    }
}
