package ejercicio_1;

public class Main {

        public static void main(String[] args) {

            Garaje garaje = new Garaje("1");

            garaje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
            garaje.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
            garaje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
            garaje.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
            garaje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
            garaje.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
            garaje.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
            garaje.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
            garaje.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
            garaje.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
            garaje.addVehiculo(new Vehiculo("Renault", "Logan", 950));

            garaje.sortVehiculosPrecio();
            garaje.imprimirListaDeVehiculosEnGaraje();
            garaje.sortVehiculosMarca();
            garaje.imprimirListaDeVehiculosEnGaraje();

            garaje.filtrarVehiculosPorCostoMenorA(1000);
            garaje.filtrarVehiculosPorCostoMayorOIgual(1000);
            garaje.precioPromedioDeVehiculosEnGaraje();

        }

}
