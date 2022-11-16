import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        listaVehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        listaVehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        listaVehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        listaVehiculos.add(new Vehiculo("Cronus", "Fiat", 1000));
        listaVehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        listaVehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        listaVehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        listaVehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        listaVehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        listaVehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1,listaVehiculos);
        System.out.println("----------------------");
        System.out.println("Ordenamiento por precio");
        /*garaje.getVehiculos().stream().sorted((x,y)->Integer.valueOf(x.getCosto()).compareTo(Integer.valueOf(y.getCosto())))
                .forEach(System.out::println);*/
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== marca+precios ordenados:");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);
    }
}