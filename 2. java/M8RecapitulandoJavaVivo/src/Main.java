import ejercicio.Garage;
import ejercicio.Vehiculo;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Vehículos
        Vehiculo fordFiesta = new Vehiculo("Ford", "Fiesta", 1000.0);
        Vehiculo fordFocus = new Vehiculo("Ford", "Focus", 1200.00);
        Vehiculo fordExplorer = new Vehiculo("Ford", "Explorer", 2500.00);
        Vehiculo fiatUno = new Vehiculo("Fiat", "Uno", 500.00);
        Vehiculo fiatCronos = new Vehiculo("Fiat", "Cronos", 1000.00);
        Vehiculo fiatTorino = new Vehiculo("Fiat", "Torino", 1250.00);
        Vehiculo chevroletAveo = new Vehiculo("Chevrolet", "Aveo", 1250.00);
        Vehiculo chevroletSpin = new Vehiculo("Chevrolet", "Spin", 2500.00);
        Vehiculo toyotaCorola = new Vehiculo("Toyota", "Corola", 1200.00);
        Vehiculo toyotaFortuner = new Vehiculo("Toyota", "Fortuner", 3000.00);
        Vehiculo renaultLogan = new Vehiculo("Renault", "Logan", 950.00);

        // Listado y guardado en garage

        Garage garage = new Garage();
        garage.addVehiculo(fordFiesta);
        garage.addVehiculo(fordFocus);
        garage.addVehiculo(fordExplorer);
        garage.addVehiculo(fiatUno);
        garage.addVehiculo(fiatCronos);
        garage.addVehiculo(fiatTorino);
        garage.addVehiculo(chevroletAveo);
        garage.addVehiculo(chevroletSpin);
        garage.addVehiculo(toyotaCorola);
        garage.addVehiculo(toyotaFortuner);
        garage.addVehiculo(renaultLogan);

        List<Vehiculo> vehiculos = garage.getVehiculos();

        // Ejercicio 3
        System.out.println(" ================================================== \n " +
                "               Ejercicio 3 \n " +
                "==================================================");
        System.out.println("------------------------------------------------- \n " +
                "             Lista de precios sin ordenar \n " +
                "------------------------------------------------- ");
        vehiculos.forEach(vehiculo -> System.out.println(vehiculo.getCosto()));
        System.out.println("------------------------------------------------- \n " +
                "             Lista de precios ordenada \n " +
                "------------------------------------------------- ");
        garage.ordenarPorCosto(vehiculos).forEach(vehiculo -> System.out.println(vehiculo.getCosto()));

        System.out.println("------------------------------------------------- \n " +
                "            Lista de vehículos sin ordenar \n " +
                "------------------------------------------------- ");
        vehiculos.forEach(System.out::println);

        System.out.println("------------------------------------------------- \n " +
                "       Lista de vehículos ordenados por precio \n " +
                "------------------------------------------------- ");
        garage.ordenarPorCosto(vehiculos).forEach(System.out::println);

        System.out.println(" ================================================== \n " +
                "               Ejercicio 4 \n " +
                "==================================================");

        System.out.println("------------------------------------------------- \n " +
                "    Lista de vehículos ordenados por Marca y Costo \n " +
                "------------------------------------------------- ");
        System.out.println(garage.ordenarPorMarcaCosto(vehiculos));

        System.out.println(" ================================================== \n " +
                "               Ejercicio 5 \n " +
                "================================================== ");
        System.out.println("------------------------------------------------- \n " +
                "            Vehículos filtrados por < 1000 \n " +
                "------------------------------------------------- ");

        System.out.println(garage.filtrarPorCostoMenor(vehiculos, 1000.00));

        System.out.println("------------------------------------------------- \n " +
                "             Vehículos filtrados por >= 1000 \n " +
                "------------------------------------------------- ");

        System.out.println(garage.filtrarPorCostoMayorIgual(vehiculos, 1000.00));


        System.out.println("------------------------------------------------- \n " +
                "               Promedio de precios \n " +
                "------------------------------------------------- ");

        System.out.println(garage.promedioCostos(vehiculos));






    } // Cierre método
} // Cierre clase