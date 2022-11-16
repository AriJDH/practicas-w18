package InterfacesYClaseAbstractas.agenciaDeTurismo;

public class Transporte extends Localizador {
    public Transporte(double precio) {
        super(precio);
    }

    @Override
    public double obtenerPrecio() {
        return 0;
    }
}
