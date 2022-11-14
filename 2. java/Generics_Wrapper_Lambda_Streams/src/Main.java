import model.Garaje;
import model.Vehiculo;

public class Main {

  public static void main(String[] args) {
    Garaje garaje = new Garaje(1);

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

    garaje.vehiculosOrdenarDeMenorPrecio();
    garaje.vehiculosOrdenarPorMarcaYPrecio();
    garaje.vehiculosObtenerMenoresA(1000);
    garaje.vehiculosObtenerMayoresA(1000);
    garaje.vehiculosPrecioPromedio();

    System.out.println(garaje.burbuja(new int[] { 1,2,3,4212,1, 2, 3, 4, 5 }));
  }
}
