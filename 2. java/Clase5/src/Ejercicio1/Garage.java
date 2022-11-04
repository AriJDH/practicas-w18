package Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Garage(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(String marca, String modelo, double precio) {
        Vehiculo vehiculo = new Vehiculo(marca, modelo, precio);
        this.vehiculos.add(vehiculo);
    }

    public static int[] burbuja(int[] array) {
        int aux;

        for(int i=1; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(array[j] > array[j+1]){

                }
            }
        }
        return array;
    }
}
