package InterfacesYClaseAbstractas.agenciaDeTurismo;

public class Comida extends Localizador {

    public Comida(double precio) {
        super(precio);
    }

    @Override
    public double obtenerPrecio() {
        return 0;
    }
}
