package Turismo.Clases;

public class Comida extends Reserva{
    String nombre;

    public Comida(double precio, String nombre) {
        super(precio);
        this.nombre = nombre;
    }
}
