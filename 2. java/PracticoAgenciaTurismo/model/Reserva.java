package model;

public class Reserva {

    private int id;
    private String tipoDeReserva;
    private double precio;


    public Reserva(int id, String tipoDeReserva, double precio) {

        this.id = id;
        this.tipoDeReserva = tipoDeReserva;
        this.precio = precio;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeReserva() {
        return tipoDeReserva;
    }

    public void setTipoDeReserva(String tipoDeReserva) {
        this.tipoDeReserva = tipoDeReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                ", id=" + id +
                ", tipoDeReserva='" + tipoDeReserva + '\'' +
                ", precio=" + precio +
                '}';
    }

}
