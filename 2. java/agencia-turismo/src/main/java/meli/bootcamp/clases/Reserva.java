package meli.bootcamp.clases;

public class Reserva {
    private long id;
    private boolean hotel;
    private boolean comida;
    private boolean viaje;
    private boolean transp;


    public Reserva(long id, boolean hotel, boolean comida, boolean viaje, boolean transp) {
        this.id = id;
        this.hotel = hotel;
        this.comida = comida;
        this.viaje = viaje;
        this.transp = transp;
    }

    public long getId() {
        return id;
    }

    public boolean isHotel() {
        return hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public boolean isViaje() {
        return viaje;
    }

    public boolean isTransp() {
        return transp;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reserva{");
        sb.append("id=").append(id);
        sb.append(", hotel=").append(hotel);
        sb.append(", comida=").append(comida);
        sb.append(", viaje=").append(viaje);
        sb.append(", transp=").append(transp);
        sb.append('}');
        return sb.toString();
    }
}
