package recap_java;

import java.util.ArrayList;
import java.util.Comparator;

public class Garaje {

    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje() {
        this.vehiculos = new ArrayList<>();
        this.id = vehiculos.size() + 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public void ordenarPorPrecio() {
        vehiculos.stream().sorted((v1, v2) -> Double.compare(v2.getCosto(), v1.getCosto()))
                .forEach(System.out::println);
    }

    public void ordenarPorPrecioYMarca() {
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
    }

    public void mostrarvarios(){
        vehiculos.stream().filter(v1 -> v1.getCosto() < 1000).forEach(System.out::println);
        System.out.println("-------------");
        vehiculos.stream().filter(v1 -> v1.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("-------------");
        System.out.println(Math.round(vehiculos.stream().mapToDouble(v1 -> v1.getCosto()).average().orElse(0)));
    }
}
