package ejemplo_patron_decorator.clases.clases_decorators;

import ejemplo_patron_decorator.interfaces.Vehiculo;

public class VidriosReforzados implements Vehiculo {

    private Vehiculo vehiculo;

    public VidriosReforzados(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public Double obtenerPrecio() {
        return this.vehiculo.obtenerPrecio() + 20.0;
    }

    @Override
    public String obtenerAccesorios() {
        return this.vehiculo.obtenerAccesorios() + "Vidrios reforzados";
    }
}
