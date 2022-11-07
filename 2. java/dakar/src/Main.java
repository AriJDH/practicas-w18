import clases.Auto;
import clases.Carrera;
import clases.Moto;
import clases.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto(24,34,353,"Prueba");
        Moto moto = new Moto(24, 34, 33, "Prueba moto");
        Auto auto1 = new Auto(22,422,32,"Prueba2");
        Auto auto2 = new Auto(22,422,32,"Prueba21");
        List<Vehiculo> lVehiculo= new ArrayList<Vehiculo>();
        lVehiculo.add(auto);
        lVehiculo.add((auto1));
        lVehiculo.add((auto2));
        //Se crea nueva carrera
        Carrera carrera = new Carrera(100, 54.2, "La gran carrera", 5,lVehiculo);
        carrera.darDeAltaAuto(23,233,233,"Prueba 3");
        carrera.darDeAltaAuto(23,232,423,"Prueba error");
        carrera.imprimirListaVehiculos();
        carrera.eliminarVehiculoConPatente("Prueba 3");
        carrera.imprimirListaVehiculos();
        carrera.socorrerAuto("Prueba2");
        carrera.socorrer(auto);
        carrera.socorrer(moto);
    }
}