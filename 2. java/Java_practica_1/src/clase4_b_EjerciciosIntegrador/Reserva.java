package clase4_b_EjerciciosIntegrador;

public class Reserva {
    protected Double precio;
    protected String tipo;

    public Reserva(Double precio, String tipo) {
        this.precio = precio;
        this.tipo = tipo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
