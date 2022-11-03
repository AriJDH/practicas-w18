import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Vehiculo> lista = new ArrayList<>();
        lista.add(new Vehiculo("Fiesta", "Ford", 1000));
        lista.add(new Vehiculo("Focus", "Ford", 1200));
        lista.add(new Vehiculo("Explorer", "Ford", 2500));
        lista.add(new Vehiculo("Uno", "Fiat", 500));
        lista.add(new Vehiculo("Cronus", "Fiat", 1000));
        lista.add(new Vehiculo("Torino", "Fiat", 1250));
        lista.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        lista.add(new Vehiculo("Spin", "Chevrolet", 2500));
        lista.add(new Vehiculo("Corola", "Toyota", 1200));
        lista.add(new Vehiculo("Fortuner", "Toyota", 3000));
        lista.add(new Vehiculo("Logan", "Renault", 950));
        Garaje garaje = new Garaje(1, lista);
        System.out.println("================================");
        System.out.println("====== Precios ordenados:");
        garaje.getLista().stream()
                .sorted((x,y)->Integer.valueOf(x.getCosto()).compareTo(Integer.valueOf(y.getCosto())))
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== marca+precios ordenados:");
        garaje.getLista().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== marca+precios ordenados (override de compareTo):");
        garaje.getLista().stream()
                .sorted(Vehiculo::compareTo)
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== lista precio no mayor 1000:");
        garaje.getLista().stream()
                .filter(v->v.getCosto()<=1000)
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== lista precio mayor o igual 1000:");
        garaje.getLista().stream()
                .filter(v->v.getCosto()>=1000)
                .forEach(System.out::println);
        System.out.println("================================");
        System.out.println("====== promedio de total de precios:");
        OptionalDouble danger = garaje.getLista()
                .stream().mapToInt(Vehiculo::getCosto)
                .average();
        System.out.println(danger.isPresent() ? danger.getAsDouble() : -1);
    }
}