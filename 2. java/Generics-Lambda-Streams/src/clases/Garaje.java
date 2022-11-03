package clases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Garaje {

    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje(int id) {
        this.id = id;
        setVehiculos();
    }

    public double calcularPromedio(){
        double promedio = 0;

        for (Vehiculo vehiculo: this.vehiculos) {
            promedio += vehiculo.getCosto();
        }

        promedio = promedio / this.vehiculos.size();

        return promedio;
    }

    public ArrayList<Vehiculo> precioMayor(){
        double max = 1000;


        ArrayList<Vehiculo> mayores = (ArrayList<Vehiculo>) this.vehiculos
                .stream()
                //filtro para obtener los números mayores a 5 y dentro se utiliza la expresión lambda (x -> x > 5)
                .filter(x -> x.getCosto() >= 1000)
                //pone los elementos que se filtró dentro de una nueva lista, dentro se utiliza una expresión lambda
                .collect(
                        Collectors.toCollection(() -> new ArrayList<Vehiculo>()));
        return mayores;
    }
    public ArrayList<Vehiculo> precioNoMayor(){
        double max = 1000;


        ArrayList<Vehiculo> mayores = (ArrayList<Vehiculo>) this.vehiculos
                .stream()
                //filtro para obtener los números mayores a 5 y dentro se utiliza la expresión lambda (x -> x > 5)
                .filter(x -> x.getCosto() < 1000)
                //pone los elementos que se filtró dentro de una nueva lista, dentro se utiliza una expresión lambda
                .collect(
                        Collectors.toCollection(() -> new ArrayList<Vehiculo>()));
        return mayores;
    }

    private void setVehiculos(){

        this.vehiculos = new ArrayList<>();
        this.vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        this.vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        this.vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        this.vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        this.vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        this.vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        this.vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        this.vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        this.vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200));
        this.vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        this.vehiculos.add(new Vehiculo("Renault", "Logan", 950));


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }


}
