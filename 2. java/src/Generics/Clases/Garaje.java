package Generics.Clases;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(int id, List<Vehiculo> listaVehiculos) {
        setId(id);
        setListaVehiculos(listaVehiculos);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
