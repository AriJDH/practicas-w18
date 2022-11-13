package modelo;

public abstract class TipoReserva {
    protected String idNombre;
    protected Double precio;

    public TipoReserva(String idNombre, Double precio) {
        this.idNombre = idNombre;
        this.precio = precio;
    }

    public Double getPrecio(){
        return this.precio;
    }

    @Override
    public String toString() {
        return "'" + idNombre + '\'' +
                " $" + String.format("%.2f", precio);
    }
}
