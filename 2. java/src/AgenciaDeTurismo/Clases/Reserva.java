package AgenciaDeTurismo.Clases;

public class Reserva {
    private boolean hotel;
    private boolean comida;
    private boolean transporte;
    private boolean boletos;

    public Reserva(boolean hotel, boolean comida, boolean transporte, boolean boletos) {
        setHotel(hotel);
        setComida(comida);
        setTransporte(transporte);
        setBoletos(boletos);
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

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    public boolean isBoletos() {
        return boletos;
    }

    public void setBoletos(boolean boletos) {
        this.boletos = boletos;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + (hotel?"Si":"No") +
                ", comida=" + (comida?"Si":"No") +
                ", transporte=" + (transporte?"Si":"No") +
                ", boletos=" + (boletos?"Si":"No") +
                '}';
    }
}
