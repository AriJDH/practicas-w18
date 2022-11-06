package model;

public class Paquete {

    private boolean reserva;
    private boolean comida;
    private boolean boleto;
    private boolean transporte;

    public Paquete(boolean reserva, boolean comida, boolean boleto, boolean transporte) {
        this.reserva = reserva;
        this.comida = comida;
        this.boleto = boleto;
        this.transporte = transporte;
    }

    public boolean isReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoleto() {
        return boleto;
    }

    public void setBoleto(boolean boleto) {
        this.boleto = boleto;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Paquete{" +
                "reserva=" + reserva +
                ", comida=" + comida +
                ", boleto=" + boleto +
                ", transporte=" + transporte +
                '}';
    }
}
