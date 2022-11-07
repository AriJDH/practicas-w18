package EjercicioVehiculos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

        public static void main(String[] args) {

            Vehiculo auto1 = new Vehiculo("Fiesta", "Ford", 1000.);
            Vehiculo auto2 = new Vehiculo("Focus", "Ford", 1200.);
            Vehiculo auto3 = new Vehiculo("Explorer", "Ford", 2500.);
            Vehiculo fiat1 = new Vehiculo("Uno", "Fiat", 500.);
            Vehiculo fiat2 = new Vehiculo("Cronos", "Fiat", 1000.);
            Vehiculo fiat3 = new Vehiculo("Torino", "Fiat", 1250.);
            Vehiculo chevrolet1 = new Vehiculo("Aveo", "Chevrolet", 1250.);
            Vehiculo chevrolet2 = new Vehiculo("Spin", "Chevrolet", 2500.);
            Vehiculo toyota1 = new Vehiculo("Corolla", "Toyota", 1200.);
            Vehiculo toyota2 = new Vehiculo("Fortuner", "Toyota", 3000.);
            Vehiculo renault = new Vehiculo("Logan", "Renault", 950.);

            List<Vehiculo> vehiculos = new ArrayList<>();
            vehiculos.add(auto1);
            vehiculos.add(auto2);
            vehiculos.add(auto3);
            vehiculos.add(fiat1);
            vehiculos.add(fiat2);
            vehiculos.add(fiat3);
            vehiculos.add(chevrolet1);
            vehiculos.add(chevrolet2);
            vehiculos.add(toyota1);
            vehiculos.add(toyota2);
            vehiculos.add(renault);


            //Ordenandolo de mayor a menor:
            vehiculos.stream().sorted((v1,v2) -> Double.compare(v2.getCosto(), v1.getCosto()))
                    .forEach(System.out::println);;

            //Ordenandolo por su precio y marca
            vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca).
                    thenComparing(Vehiculo::getCosto)).forEach(System.out::println);;

            //Ordenandolo si tiene precio mayor a 1000
            vehiculos.stream().filter(v -> v.getCosto() >= 1000).forEach(System.out::println);

            //Ordenar por precio menor a 1000
            vehiculos.stream().filter(v -> v.getCosto() < 1000).forEach(System.out::println);

            //calcular promedio
            System.out.println(vehiculos.stream().mapToDouble(a -> a.getCosto()).average().orElse(0));



        }

    }

