package Recapitulando_Java_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos; // aca me relaciona esta lista con la clase Vehiculos?

    public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo v){
        this.vehiculos.add(v);
    }

    public void vehiculosDeMayoraMenor() {
    vehiculos.stream()
            .sorted(Comparator.comparing(Vehiculo::getCosto))
        .forEach(System.out::println);
    }
}
