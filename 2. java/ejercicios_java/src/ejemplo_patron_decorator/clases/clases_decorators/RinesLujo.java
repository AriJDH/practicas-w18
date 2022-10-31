package ejemplo_patron_decorator.clases.clases_decorators;

import ejemplo_patron_decorator.interfaces.Vehiculo;

public class RinesLujo implements Vehiculo {

    private Vehiculo vehiculo;

    public RinesLujo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double obtenerPrecio() {
        return this.vehiculo.obtenerPrecio() + 10.0;
    }

    @Override
    public String obtenerAccesorios() {
        return this.vehiculo.obtenerAccesorios() + "Rines de lujo";
    }
}
