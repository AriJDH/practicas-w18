
/*Ejercicio 1
Inicia creando una clase Vehículo con los atributos modelo, marca y costo. Luego crea una clase garaje
con los atributos id o identificador único y una lista de vehículos. Crea además los constructores de las clases y
los métodos Setter y Getter.
*/
package Ejercicio1Vehiculos.Clases;

import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehiculo> listaVehiculos= new ArrayList<>();


    public Garage(int id, ArrayList<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
