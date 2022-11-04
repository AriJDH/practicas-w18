public class ReservaBoleto extends Reserva{

    private boolean descuentoDelCinco;

    public ReservaBoleto(String nombre, double costo) {
        super(nombre, costo);
        this.descuentoDelCinco = false;
    }

    @Override
    public String toString() {
        return "\nReservaBoleto "+ super.getNombre() +" costo: "+super.getCosto();
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
