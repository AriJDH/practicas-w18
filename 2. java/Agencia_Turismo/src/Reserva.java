public class Reserva {

    private String tipo; // Puede ser Hotel,Boleto,Comida o Transporte
    private int cantidad;
    private double precio;

    public Reserva(String tipo, int cantidad, double precio) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}
