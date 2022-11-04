package ejercicio1;

import ejercicio1.model.Garaje;
import ejercicio1.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Garaje garaje = new Garaje(1);

        List<Vehiculo> vehiculosList = new ArrayList<>();
        vehiculosList.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculosList.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculosList.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculosList.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculosList.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculosList.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculosList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculosList.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculosList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculosList.add(new Vehiculo("Renault", "Logan", 950));


        garaje.setVehiculos(vehiculosList);
        garaje.imprimirList();

        garaje.ordenarVehiculosPorCosto();
        garaje.ordenarVehiculosPorMarcaYLuegoCosto();

        garaje.filtrarVehiculosPorCostoMenorA(1000);
        garaje.filtrarVehiculosPorCostoMayorA(1000);

        garaje.obtenerCostoPromedioDeVehiculos();

    }

}

