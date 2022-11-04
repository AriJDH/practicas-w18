public abstract class Reservable implements IDescuento{

    // Atributos
    protected Double precio;
    protected Double descuentoAplicado;

    // Constructores
    public Reservable() {
    }

    public Reservable(Double precio, Double descuentoAplicado) {
        this.precio = precio;
        this.descuentoAplicado = descuentoAplicado;
    }

    // Getters
    public Double getPrecio() {
        return precio;
    }

    public Double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    // Métodos

    public abstract Double calcularPrecio();

    @Override
    public String toString() {
        return "Reservable{" +
                "precio=" + precio +
                ", descuentoAplicado=" + descuentoAplicado +
                '}';
    }
}
