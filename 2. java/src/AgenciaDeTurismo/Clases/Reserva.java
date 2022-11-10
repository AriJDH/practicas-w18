package AgenciaDeTurismo.Clases;

public class Reserva {
    private boolean hotel;
    private boolean comida;
    private boolean transporte;
    private boolean boletos;
    private Double costoReserva;
    private Long codigoReserva = 0L;

    public Reserva(boolean hotel, boolean comida, boolean transporte, boolean boletos, Double costoReserva) {
        setHotel(hotel);
        setComida(comida);
        setTransporte(transporte);
        setBoletos(boletos);
        setCostoReserva(costoReserva);
    }

    public Double getCostoReserva() {
        return costoReserva;
    }

    public void setCostoReserva(Double costoReserva) {

        if (hotel && comida && transporte && boletos) {
            this.costoReserva = (costoReserva - (costoReserva * (5/100)));
        }else{
            this.costoReserva = costoReserva;
        }
    }

    public Long getCodigoReserva() {
        return codigoReserva +=1L;
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
                "hotel=" + (isHotel()?"Si":"No") +
                ", comida=" + (isComida()?"Si":"No") +
                ", transporte=" + (isTransporte()?"Si":"No") +
                ", boletos=" + (isBoletos()?"Si":"No") +
                ", codigo reserva=" + getCodigoReserva()+
                ", costo reserva=" + getCostoReserva()+
                '}';
    }
}
