import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo v2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo v3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo v4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo v5 = new Vehiculo("Fiat", "Crono", 1000);
        Vehiculo v6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo v7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo v8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo v9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo v10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo v11 = new Vehiculo("Renault", "Logan", 950);
        List<Vehiculo> veh = new ArrayList<>();
        veh.add(v1);
        veh.add(v2);
        veh.add(v3);
        veh.add(v4);
        veh.add(v5);
        veh.add(v6);
        veh.add(v7);
        veh.add(v8);
        veh.add(v9);
        veh.add(v10);
        veh.add(v11);


        Garaje gar = new Garaje("IDAN", veh);
        System.out.println("La lista ordenada por precio");
        veh.sort(Comparator.comparing(Vehiculo::getCosto));
        veh.forEach(System.out::println);

        System.out.println("La lista ordenada por marca y precio");
        veh.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Comparator.comparing(Vehiculo::getCosto)));
        veh.forEach(System.out::println);


        System.out.println("Listado de autos con precios menor a $1000 (Mil)");
        veh.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("Listado de autos con precios mayor o igual a $1000 (Mil)");
        veh.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);


        System.out.println("El precio promedio de los autos es: ");
        veh.stream().mapToDouble(vehiculo -> vehiculo.getCosto()).average();
    }


}
