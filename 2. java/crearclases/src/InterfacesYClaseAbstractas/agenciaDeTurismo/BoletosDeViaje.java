package InterfacesYClaseAbstractas.agenciaDeTurismo;

public class BoletosDeViaje extends Localizador {
    public BoletosDeViaje(double precio) {
        super(precio);
    }

    @Override
    public double obtenerPrecio() {
        return 0;
    }
}
