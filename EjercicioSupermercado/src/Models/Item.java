package Models;

public class Item {
    private Long codigo;
    private String nombre;
    private int cantidadCantidad;
    private double costoUnitario;

    public Item() {
    }

    public Item(Long codigo, String nombre, int cantidadCantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadCantidad = cantidadCantidad;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadCantidad() {
        return cantidadCantidad;
    }

    public void setCantidadCantidad(int cantidadCantidad) {
        this.cantidadCantidad = cantidadCantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidadCantidad=" + cantidadCantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
