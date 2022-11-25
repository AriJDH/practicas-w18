public class Paquete {
    private String hotel;
    private String comida;
    private String boletos;
    private String transporte;

    public Paquete(String hotel, String comida, String boletos, String transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public String getBoletos() {
        return boletos;
    }

    public void setBoletos(String boletos) {
        this.boletos = boletos;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
}
