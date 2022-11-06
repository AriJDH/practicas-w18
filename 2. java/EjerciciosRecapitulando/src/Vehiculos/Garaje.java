package Vehiculos;

import java.util.ArrayList;

public class Garaje {
    protected Integer id;
    protected ArrayList<Vehiculo > ListaDeVehiculos;

    public Garaje(Integer id, ArrayList<Vehiculo> listaDeVehiculos) {
        this.id = id;
        ListaDeVehiculos = listaDeVehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return ListaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        ListaDeVehiculos = listaDeVehiculos;
    }
}
