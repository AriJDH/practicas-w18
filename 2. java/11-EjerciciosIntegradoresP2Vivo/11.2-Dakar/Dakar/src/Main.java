import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creamos autos y motos
        Auto auto1 = new Auto(
                100.0,
                0.3,
                10.00,
                "AB123CD");

        Auto auto2 = new Auto(
                120.0,
                0.5,
                15.00,
                "AB456CD");

        Moto moto1 = new Moto(
                140.0,
                0.2,
                15.0,
                "A123NMB");

        Moto moto2 = new Moto(
                130.0,
                0.3,
                10.0,
                "W258GHJ");

        // Creamos la carrera
        List<Vehiculo> vehiculos = new ArrayList<>();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        Carrera carrera = new Carrera(
                1000.0,
                3000.00,
                "Gran Premio",
                5,
                vehiculos,
                socorristaAuto,
                socorristaMoto);

        // Agregamos los vehículos
        carrera.darDeAltaAuto(130.0,
                0.3,
                12.0,
                "AB152SD");
        carrera.darDeAltaAuto(140.0,
                0.2,
                9.0,
                "AB123SD");
        carrera.darDeAltaMoto(150.0,
                0.1,
                8.0,
                "B259ASD");
        carrera.darDeAltaMoto(155.0,
                0.1,
                10.0,
                "B257ASD");

        carrera.eliminarVehiculo(vehiculos.get(0));
        carrera.eliminarVehiculoConPatente("AB123SD");

        carrera.darDeAltaAuto(130.0,
                0.2,
                10.0,
                "AC123SD");
        carrera.darDeAltaMoto(140.0,
                0.1,
                10.0,
                "Z259ASD");
        carrera.darDeAltaMoto(145.0,
                0.1,
                10.0,
                "S257ASD");

        carrera.definirGanadorDeCarrera();

        carrera.socorrerAuto("AC123SD");
        carrera.socorrerMoto("Z259ASD");


    }
}