package model;

public class Item {

    // Atributos
    private Long codigo;
    private String nombre;
    private Integer cantidad;
    private Double costoUnitario;

    // Constructores
    public Item() {
    }

    public Item(Long codigo,
                String nombre,
                Integer cantidad,
                Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    // Getters y setters
    public Long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getCosto() {
        return costoUnitario;
    }

    // Métodos
    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
