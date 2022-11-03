import autos.Garage;
import autos.Vehiculo;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage(1);

        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);

        garage.agregarVehiculos(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11);

        garage.imprimirVehiculosOrdenadosPorPrecioAscendente();
        garage.imprimirVehiculosOrdenadosPorMarcaYPrecio();
        garage.imprimirVehiculosConPrecioMenorIgualA1000();
        garage.imprimirVehiculosConPrecioMayorIgualA1000();
        garage.imprimirCostoPromedioVehiculos();



    }
}