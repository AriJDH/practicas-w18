package ejemplo_patron_decorator.clases.clases_decorators;

import ejemplo_patron_decorator.interfaces.Vehiculo;

public class ChapaProtectora implements Vehiculo {

    private Vehiculo vehiculo;

    public ChapaProtectora(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double obtenerPrecio() {
        return this.vehiculo.obtenerPrecio() + 15.0;
    }

    @Override
    public String obtenerAccesorios() {
        return this.vehiculo.obtenerAccesorios() + "Chapa protectora";
    }
}
