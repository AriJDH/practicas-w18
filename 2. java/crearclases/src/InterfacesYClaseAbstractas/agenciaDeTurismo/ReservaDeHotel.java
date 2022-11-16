package InterfacesYClaseAbstractas.agenciaDeTurismo;

public class ReservaDeHotel extends Localizador {
    public ReservaDeHotel(double precio) {
        super(precio);
    }

    @Override
    public double obtenerPrecio() {
        return 0;
    }
}
