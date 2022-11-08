import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino","Fiat",1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",950);

        List<Vehiculo> vehiculoList = new ArrayList<>();

        vehiculoList.add(vehiculo1);
        vehiculoList.add(vehiculo2);
        vehiculoList.add(vehiculo3);
        vehiculoList.add(vehiculo4);
        vehiculoList.add(vehiculo5);
        vehiculoList.add(vehiculo6);
        vehiculoList.add(vehiculo7);
        vehiculoList.add(vehiculo8);
        vehiculoList.add(vehiculo9);
        vehiculoList.add(vehiculo10);
        vehiculoList.add(vehiculo11);

        Garage garage = new Garage(1,vehiculoList);

        System.out.println("\nOrdenados por precio");
        System.out.println("--------------------");
        vehiculoList.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).forEach(System.out::println);

        System.out.println("\nOrdenados por marca y después precio");
        System.out.println("--------------------------------------");
        Comparator<Vehiculo> comparator = Comparator.comparing(auto -> auto.getMarca());
        comparator = comparator.thenComparing(Comparator.comparing(auto -> auto.getCosto()));
        vehiculoList.stream().sorted(comparator).forEach(System.out::println);

        //Otra forma
        //garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

        List<Vehiculo> vehiculosHastaMil = new ArrayList<>();
        vehiculosHastaMil = vehiculoList.stream().filter(p -> p.getCosto() < 1000).collect(Collectors.toList());

        System.out.println("\nVehículos no mayor a $1000");
        System.out.println("--------------------------------------");
        vehiculosHastaMil.stream().forEach(System.out::println);

        List<Vehiculo> vehiculosMayorAMil = new ArrayList<>();
        vehiculosMayorAMil = vehiculoList.stream().filter(p -> p.getCosto() >= 1000).collect(Collectors.toList());

        System.out.println("\nVehículos mayor o igual a $1000");
        System.out.println("--------------------------------------");
        vehiculosMayorAMil.stream().forEach(System.out::println);

        System.out.println("\nPromedio");
        System.out.println("--------------------------------------");
        System.out.println(vehiculoList.stream()
                .mapToDouble(a -> a.getCosto())
                .average().orElse(0));

    }
}









