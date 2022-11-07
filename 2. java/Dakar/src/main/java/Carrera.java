import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Carrera {

    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDegiro, String patente){
        if (cantidadDeVehiculosPermitidos >= vehiculos.size())
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDegiro, patente));
        else
            System.out.println("Cantidad de vehiculos para esta carrera se encuentra lleno.");
    }

    public void imprimirVehiculosEnCarrera(){
        vehiculos.forEach(Vehiculo::imprimir);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDegiro, String patente){
        if (cantidadDeVehiculosPermitidos >= vehiculos.size())
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDegiro, patente));
        else
            System.out.println("Cantidad de vehiculos para esta carrera se encuentra lleno.");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPantete(String unaPatente){
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getPatente().equals(unaPatente)){
                vehiculos.remove(vehiculo);
                return;
            }
        }
    }

    public void definirGanador(){
        AtomicInteger counter = new AtomicInteger(1);
        List <Vehiculo> tempVehiculos = new ArrayList<Vehiculo>(vehiculos);
        tempVehiculos.forEach(Vehiculo::setPuntaje);
        tempVehiculos.sort(Comparator.comparingDouble(Vehiculo::getPuntaje));
        Collections.reverse(tempVehiculos);
        System.out.println("Definiendo ganadores");
        System.out.println("----------------------------------------------------------------");
        tempVehiculos.forEach(v -> {
            System.out.println(counter + "º) -- " + v.toString() + "\n");
            counter.getAndIncrement();
        });
    }


    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }
}
