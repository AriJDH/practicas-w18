public class ReservaHotel extends Reserva{
    boolean descuentoDelCinco;
    public ReservaHotel(String nombre, double costo) {
        super(nombre, costo);
        this.descuentoDelCinco = false;
    }

    @Override
    public String toString() {
        return "\nReservaHotel " + super.getNombre() +" costo: "+super.getCosto();
    }


    @Override
    public double getCosto() {
        if (descuentoDelCinco){
            return super.getCosto() * 0.95;
        }else{
            return super.getCosto();
        }

    }

    public void setDescuentoDelCinco(boolean descuentoDelCinco) {
        this.descuentoDelCinco = descuentoDelCinco;
    }

    public boolean isDescuentoDelCinco() {
        return descuentoDelCinco;
    }
}
