import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera();
        carrera.setDistancia(1000.0);
        carrera.setNombre("Carrera del desierto");
        carrera.setPremioEnDolares(1000.0);
        carrera.setCantidadDeVehiculosPermitidos(3);

        System.out.println("Bienvenidos a la carrera: " + carrera.getNombre());
        System.out.println("El ganador se llevará: " + carrera.getPremioEnDolares() + " dólares");
        System.out.println("La distancia que ese recorrerá serán: " + carrera.getDistancia() + " km");

        System.out.println("\nA continuación verá los vehículos que intentaran darse de alta: ");
        carrera.darDeAltaAuto(150, 120, 100,"BCD");
        carrera.darDeAltaAuto(180, 140, 110,"DEF");
        carrera.darDeAltaMoto(120, 100, 90, "ABC");
        carrera.darDeAltaMoto(90, 80, 70, "FGH");

        System.out.println("\nEl vehículo ganador fue: ");
        System.out.println(carrera.ganador());

        System.out.println("\n");
        carrera.socorrerAuto("BCD");
    }
}



