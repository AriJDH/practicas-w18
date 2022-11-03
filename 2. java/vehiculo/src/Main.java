import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        Vehiculo vehiculo1 = new Vehiculo("Ford","Fiesta",1000);
        Vehiculo vehiculo2 = new Vehiculo("Ford","Focus",1200);
        Vehiculo vehiculo3 = new Vehiculo("Ford","Explorer",2500);
        Vehiculo vehiculo4 = new Vehiculo("Fiat","Uno",500);
        Vehiculo vehiculo5 = new Vehiculo("Fiat","Cronos",1000);
        Vehiculo vehiculo6 = new Vehiculo("Fiat","Torino",1250);
        Vehiculo vehiculo7 = new Vehiculo("Chevrolet","Aveo",1250);
        Vehiculo vehiculo8 = new Vehiculo("Chevrolet","Spin",2500);
        Vehiculo vehiculo9 = new Vehiculo("Toyota","Corolla",1200);
        Vehiculo vehiculo10 = new Vehiculo("Toyota","Fortuner",3000);
        Vehiculo vehiculo11 = new Vehiculo("Renault","Logan",950);

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garage garage = new Garage(1,vehiculos);
        //Ejercicio 3
        //garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto).reversed()).forEach(System.out::println);
        //garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 4
        //garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        //Ejercicio 5
        //garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::println);
        //garage.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(System.out::println);
        //garage.getVehiculos().stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average().stream().forEach(System.out::println);

    }
}