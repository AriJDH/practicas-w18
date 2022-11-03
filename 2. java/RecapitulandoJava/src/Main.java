public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        garage.guardarVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garage.guardarVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garage.guardarVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garage.guardarVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garage.guardarVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garage.guardarVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garage.guardarVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garage.guardarVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garage.guardarVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garage.guardarVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.guardarVehiculo(new Vehiculo("Renaul", "Logan", 950));


         garage.ordenadosPorPrecio();
         garage.ordenadosPorMarcaYPrecio();
         garage.preciosOrdenados();
    }
}