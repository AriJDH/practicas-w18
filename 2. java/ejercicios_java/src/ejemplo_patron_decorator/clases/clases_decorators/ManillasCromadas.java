package ejemplo_patron_decorator.clases.clases_decorators;

import ejemplo_patron_decorator.interfaces.Vehiculo;

public class ManillasCromadas implements Vehiculo {

    private Vehiculo vehiculo;

    public ManillasCromadas(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double obtenerPrecio() {
        return this.vehiculo.obtenerPrecio() + 12.5;
    }

    @Override
    public String obtenerAccesorios() {
        return this.vehiculo.obtenerAccesorios() + " Manillas cromadas ";
    }
}
