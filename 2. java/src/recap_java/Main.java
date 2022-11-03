package recap_java;

public class Main {

    public static void main(String[] args) {
        Garaje garaje = new Garaje();

        Vehiculo ford1 = new Vehiculo("Fiesta", "Ford", 1000.);
        Vehiculo ford2 = new Vehiculo("Focus", "Ford", 1200.);
        Vehiculo ford3 = new Vehiculo("Explorer", "Ford", 2500.);
        Vehiculo fiat1 = new Vehiculo("Uno", "Fiat", 500.);
        Vehiculo fiat2 = new Vehiculo("Cronos", "Fiat", 1000.);
        Vehiculo fiat3 = new Vehiculo("Torino", "Fiat", 1250.);
        Vehiculo chevrolet1 = new Vehiculo("Aveo", "Chevrolet", 1250.);
        Vehiculo chevrolet2 = new Vehiculo("Spin", "Chevrolet", 2500.);
        Vehiculo toyota1 = new Vehiculo("Corolla", "Toyota", 1200.);
        Vehiculo toyota2 = new Vehiculo("Fortuner", "Toyota", 3000.);
        Vehiculo renault = new Vehiculo("Logan", "Renault", 950.);

        garaje.agregarVehiculo(ford1);
        garaje.agregarVehiculo(ford2);
        garaje.agregarVehiculo(ford3);
        garaje.agregarVehiculo(fiat1);
        garaje.agregarVehiculo(fiat2);
        garaje.agregarVehiculo(fiat3);
        garaje.agregarVehiculo(chevrolet1);
        garaje.agregarVehiculo(chevrolet2);
        garaje.agregarVehiculo(toyota1);
        garaje.agregarVehiculo(toyota2);
        garaje.agregarVehiculo(renault);

        garaje.ordenarPorPrecio();

        System.out.println("--------------------");

        garaje.ordenarPorPrecioYMarca();

        garaje.mostrarvarios();
    }
}
