public class Paquete {
    private String reservasHotel;
    private String comida;
    private String boletoViaje;
    private String transporte;
    private double costo;

    public Paquete(String reservasHotel, String comida, String boletoViaje, String transporte, double costo) {
        this.reservasHotel = reservasHotel;
        this.comida = comida;
        this.boletoViaje = boletoViaje;
        this.transporte = transporte;
        this.costo = costo;
    }

    public String getReservasHotel() {
        return reservasHotel;
    }

    public void setReservasHotel(String reservasHotel) {
        this.reservasHotel = reservasHotel;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getBoletoViaje() {
        return boletoViaje;
    }

    public void setBoletoViaje(String boletoViaje) {
        this.boletoViaje = boletoViaje;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
