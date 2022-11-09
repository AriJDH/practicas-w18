import java.util.ArrayList;
import java.util.Comparator;


public class Main {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault","Logan",950));


        Garaje garaje = new Garaje(1,vehiculos);

        System.out.println("Vehiculos ordenados por precio de menor a mayor\n");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\n Vehiculos ordenados por marca y precio \n");
        garaje.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\nLista de vehiculos con precio menor a 1000\n");
        garaje.getVehiculos().stream().filter( vehicle -> vehicle.getCosto()< 1000).forEach(System.out::println);

        System.out.println("\nLista de vehiculos con precio mayor o igual a 1000\n");
        garaje.getVehiculos().stream().filter( vehicle -> vehicle.getCosto()>= 1000).forEach(System.out::println);

        System.out.println("\nPromedio de precio");
        System.out.println(garaje.getVehiculos().stream().mapToInt(vehicle -> vehicle.getCosto()).average().getAsDouble());



    }

}
