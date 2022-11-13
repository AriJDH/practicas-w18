import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Garage garage = new Garage();
        List<Vehiculo> vehiculosList = new ArrayList<>();

        vehiculosList.add(new Vehiculo("focus", "ford", 1000));
        vehiculosList.add(new Vehiculo("fiesta","ford",1200));
        vehiculosList.add(new Vehiculo("explorer","ford",2500));
        vehiculosList.add(new Vehiculo("Uno","fiat",500));
        vehiculosList.add(new Vehiculo("cronos", "fiat",1000));
        vehiculosList.add(new Vehiculo("torino","fiat",1250));
        vehiculosList.add(new Vehiculo("aveo", "chevrolet",1250));
        vehiculosList.add(new Vehiculo("spin", "chevrolet", 2500));
        vehiculosList.add(new Vehiculo("corola","toyota",1200));
        vehiculosList.add(new Vehiculo("fortuner","toyota",3000));
        vehiculosList.add(new Vehiculo("logan","renault",950));

        garage.setVehiculos(vehiculosList);
        //Stream.of(garage.getVehiculos()).map(vehiculo -> vehiculo.toString()).forEach(System.out::println);
//        vehiculosList.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);
        //vehiculosList.stream().sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto)).forEach(System.out::println);

       // vehiculosList.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
       // vehiculosList.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);
        System.out.println(vehiculosList.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average());





    }
}