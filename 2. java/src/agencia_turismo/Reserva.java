package agencia_turismo;

public class Reserva {
    private String descripcion;
    private TipoReserva tipoReserva;
    private double precio;
    private double precioPostDescuentos;

    public Reserva(String descripcion, TipoReserva tipoReserva, double precio) {
        this.descripcion = descripcion;
        this.tipoReserva = tipoReserva;
        this.precio = precio;
        this.precioPostDescuentos = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioPostDescuentos() {
        return precioPostDescuentos;
    }

    public void setPrecioPostDescuentos(double precioPostDescuentos) {
        this.precioPostDescuentos = precioPostDescuentos;
    }

    @Override
    public String toString() {
        return descripcion + ". Tipo de reserva: " + this.tipoReserva.toString() + ". Precio: " + this.precio +
                ". Precio post descuentos: " + this.precioPostDescuentos + ".";
    }
}
