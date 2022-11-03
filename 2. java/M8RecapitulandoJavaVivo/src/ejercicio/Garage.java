package ejercicio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {

    // Atributos
    private Long id;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    // Constructores
    public Garage() {
    }

    public Garage(Long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Métodos
    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public List<Vehiculo> ordenarPorCosto(List<Vehiculo> vehiculos) {
        vehiculos.sort((vehiculo1, vehiculo2) ->
        {
            if (vehiculo1.getCosto() >= vehiculo2.getCosto()) {
                return 1;
            } else return -1;
        });
        return vehiculos;
    }

    public List<Vehiculo> ordenarPorMarcaCosto(List<Vehiculo> vehiculos) {

        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        // vehiculos.sort(Comparator.comparing(Vehiculo::getMarca));

        return vehiculos;
    }

    public List<Vehiculo> filtrarPorCostoMenor(List<Vehiculo> vehiculos,
                                               Double costo) {
        return vehiculos
                .stream()
                .filter(v -> v.getCosto() < costo)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> filtrarPorCostoMayorIgual(List<Vehiculo> vehiculos,
                                                    Double costo) {
        return vehiculos
                .stream()
                .filter(v -> v.getCosto() >= costo)
                .collect(Collectors.toList());
    }

    public Double promedioCostos(List<Vehiculo> vehiculos) {
        return vehiculos.stream().mapToDouble(value -> value.getCosto()).average().orElse(0.00);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}

