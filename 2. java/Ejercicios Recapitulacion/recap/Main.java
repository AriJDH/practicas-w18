package recap;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> misVehiculos = new ArrayList<>();
        Garaje miGaraje = new Garaje(1);

        misVehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        misVehiculos.add(new Vehiculo("Ford", "Focus",1200));
        misVehiculos.add(new Vehiculo("Ford","Explorer",2500));
        misVehiculos.add(new Vehiculo("Fiat","Uno",500));
        misVehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        misVehiculos.add(new Vehiculo("Fiat","Torino",1250));
        misVehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        misVehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        misVehiculos.add(new Vehiculo("Toyota","Corola",1200));
        misVehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        misVehiculos.add(new Vehiculo("Renault","Logan",950));


        miGaraje.setVehiculos(misVehiculos);
        System.out.println("Ejercicio 3:");
        miGaraje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\nEjercicio 4");
        miGaraje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("\nEjercicio 5");
        System.out.println("Vehiculos con precio menor a 1000\n");
        miGaraje.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("\nVehiculos con precio mayor o igual a 1000\n");
        miGaraje.getVehiculos()
                .stream()
                .filter(x -> x.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println("\nPromedio del precio de los vehiculos");
        int promedio = miGaraje.getVehiculos()
                                 .stream()
                                 .mapToInt(Vehiculo::getCosto).sum()/miGaraje.getVehiculos().size();
        System.out.println(promedio);


    }


}
