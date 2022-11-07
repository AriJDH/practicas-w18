package ejercicio_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {

    private String id;
    private List<Vehiculo>  vehiculosList = new ArrayList<Vehiculo>();

    public Garaje(String id) {
        this.id = id;
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculosList.add(vehiculo);
    }

    public void imprimirListaDeVehiculosEnGaraje(){
        System.out.println("----------------------------------------------------------------\n");
        vehiculosList.forEach(Vehiculo::imprimirDatos);
        System.out.println("----------------------------------------------------------------\n");
    }

    public void sortVehiculosPrecio(){
        vehiculosList.sort(Comparator.comparing(Vehiculo::getCosto));
    }

    public void sortVehiculosMarca(){
        vehiculosList.sort(Comparator.comparing(Vehiculo::getMarca));
    }

    public void filtrarVehiculosPorCostoMenorA(Integer costo){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Filtrando vehiculos por un costo menor a $" + costo + ": \n");
        List<Vehiculo> filteredVehiculos = vehiculosList
                .stream()
                .filter(v -> v.getCosto() < costo)
                .collect(Collectors.toList());
        filteredVehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        filteredVehiculos.stream().forEach(Vehiculo::imprimirDatos);
        System.out.println("----------------------------------------------------------------\n");
    }

    public void filtrarVehiculosPorCostoMayorOIgual(Integer costo){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Filtrando vehiculos por un costo mayor o igual a $" + costo + ": \n");
        List<Vehiculo> filteredVehiculos = vehiculosList
                .stream()
                .filter(v -> v.getCosto() >= costo)
                .collect(Collectors.toList());
        filteredVehiculos.sort(Comparator.comparing(Vehiculo::getCosto));
        filteredVehiculos.stream().forEach(Vehiculo::imprimirDatos);
        System.out.println("----------------------------------------------------------------\n");
    }

    public void precioPromedioDeVehiculosEnGaraje(){
        System.out.println("----------------------------------------------------------------");
        double avgCosto = (double) (vehiculosList
                .stream()
                .mapToInt(Vehiculo::getCosto)
                .sum() / vehiculosList.size());
        System.out.println("precio promedio de los vehiculos en el garaje es de: $" + avgCosto);
        System.out.println("----------------------------------------------------------------\n");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculo> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }
}
