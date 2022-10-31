package ejemplo_patron_decorator.clases;

import ejemplo_patron_decorator.clases.clases_decorators.ChapaProtectora;
import ejemplo_patron_decorator.clases.clases_decorators.ManillasCromadas;
import ejemplo_patron_decorator.clases.clases_decorators.RinesLujo;
import ejemplo_patron_decorator.clases.clases_decorators.VidriosReforzados;
import ejemplo_patron_decorator.interfaces.Vehiculo;

public class Main {

    public static void main(String[] args) {

        Vehiculo vehiculo = new VidriosReforzados(
                new ChapaProtectora(
                        new RinesLujo(
                                new ManillasCromadas(
                                    new VehiculoBase(100.0, "mazda", "espejo")))));

        System.out.println("Precio vehiculo " + vehiculo.obtenerPrecio());
        System.out.println("Accesorios " + vehiculo.obtenerAccesorios());

        Vehiculo vehiculoSimple = new ManillasCromadas(
                new VehiculoBase(100.0, "renault", "espejo"));

        System.out.println("Precio vehiculo " + vehiculoSimple.obtenerPrecio());
        System.out.println("Accesorios " + vehiculoSimple.obtenerAccesorios());
    }
}
