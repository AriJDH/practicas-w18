package InterfacesYClaseAbstractas.agenciaDeTurismo;

public abstract class Localizador implements Obtenible{
    private double precio;

    public Localizador(double precio) {
        this.precio = precio;
    }
}
