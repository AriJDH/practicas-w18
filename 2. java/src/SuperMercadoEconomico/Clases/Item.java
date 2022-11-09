package SuperMercadoEconomico.Clases;

public class Item {
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private Double costo;

    public Item(String codigo, String nombre, Integer cantidad, Double costo) {
        setCodigo(codigo);
        setNombre(nombre);
        setCantidad(cantidad);
        setCosto(costo);
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}
