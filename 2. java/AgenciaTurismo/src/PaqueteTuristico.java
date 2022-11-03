public class PaqueteTuristico {

    boolean hotel;
    boolean comida;
    boolean pasaje;
    boolean transporte;
    boolean completo;

    double precio;


    @Override
    public String toString() {
        return "PaqueteTuristico{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", pasaje=" + pasaje +
                ", transporte=" + transporte +
                ", completo=" + completo +
                ", precio=$ " +
                '}';
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isPasaje() {
        return pasaje;
    }

    public void setPasaje(boolean pasaje) {
        this.pasaje = pasaje;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public PaqueteTuristico(boolean hotel, boolean comida, boolean pasaje, boolean transporte, boolean completo) {
        this.hotel = hotel;
        this.comida = comida;
        this.pasaje = pasaje;
        this.transporte = transporte;
        this.completo = completo;

    }
}
