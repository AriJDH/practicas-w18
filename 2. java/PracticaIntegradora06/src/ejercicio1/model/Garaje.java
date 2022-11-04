package ejercicio1.model;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculos;


    public Garaje(int id) {
        this.id = id;
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


    public void imprimirList() {

        System.out.println();
        System.out.println("Imprimiendo Lista");
        System.out.println("------------------------------------------------------------------------");

        this.vehiculos.forEach(System.out::println);

        System.out.println();
    }

    public void ordenarVehiculosPorCosto() {

        System.out.println();
        System.out.println("Imprimiendo Lista Ordenada por Costo");
        System.out.println("------------------------------------------------------------------------");

        this.vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println();
    }

    public void ordenarVehiculosPorMarcaYLuegoCosto() {

        System.out.println();
        System.out.println("Imprimiendo Lista Ordenada por Marca y luego Costo");
        System.out.println("------------------------------------------------------------------------");

        this.vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        System.out.println();
    }

    public void filtrarVehiculosPorCostoMenorA(int costoMaximo) {

        System.out.println();
        System.out.println("Imprimiendo Lista de Vehiculos con un costo Menor o igual a: " + costoMaximo);
        System.out.println("------------------------------------------------------------------------");

        this.vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() <= costoMaximo)
                .forEach(System.out::println);

        System.out.println();
    }

    public void filtrarVehiculosPorCostoMayorA(int costoMinimo) {

        System.out.println();
        System.out.println("Imprimiendo Lista de Vehiculos con un costo Mayor o igual a: " + costoMinimo);
        System.out.println("------------------------------------------------------------------------");

        this.vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= costoMinimo)
                .forEach(System.out::println);

        System.out.println();
    }

    public void obtenerCostoPromedioDeVehiculos() {

        System.out.println();
        System.out.println("Imprimiendo el Costo Promedio de los Vehiculos en la lista: ");

        OptionalDouble optionalDouble;

        optionalDouble = this.vehiculos
                .stream()
                .mapToDouble(Vehiculo::getCosto).average();

        if (optionalDouble.isPresent()) {
            System.out.println((int) optionalDouble.getAsDouble());
        } else {
            System.out.println("No se pudo calcular el Promedio");
        }

        System.out.println();
    }

}
