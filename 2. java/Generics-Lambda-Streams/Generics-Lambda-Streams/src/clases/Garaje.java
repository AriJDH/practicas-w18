package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Garaje {
    private int id;
    private ArrayList<Vehiculo> vehiculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Garaje(){}
    public Garaje(int id){
        this.id = id;
        setVehiculos();
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public void setVehiculos(){
        vehiculos = new ArrayList<>();
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

    public ArrayList<Vehiculo> precioNoMayor(){
        double max = 1000;
        ArrayList<Vehiculo> listaMayores = (ArrayList<Vehiculo>) this.vehiculos
                .stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(
                        Collectors.toCollection(() -> new ArrayList<Vehiculo>())
                );
        return  listaMayores;
    }

    public ArrayList<Vehiculo> precioMayor(){
        double max = 1000;
        ArrayList<Vehiculo> listaMayores = (ArrayList<Vehiculo>) this.vehiculos
                .stream()
                .filter(x -> x.getCosto() >= 1000)
                .collect(
                        Collectors.toCollection(() -> new ArrayList<Vehiculo>())
                );
        return  listaMayores;
    }
    public double calcularPromedio(){
        double promedio = 0;
        for(Vehiculo vehiculo : this.vehiculos){
            promedio += vehiculo.getCosto();
        }
        promedio = promedio / this.vehiculos.size();
        return promedio;
    }

}
