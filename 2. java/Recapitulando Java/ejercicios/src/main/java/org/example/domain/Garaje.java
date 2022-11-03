package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private long id;
    private List<Vehiculo> vehiculos = new ArrayList<>();

    public Garaje(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
}
