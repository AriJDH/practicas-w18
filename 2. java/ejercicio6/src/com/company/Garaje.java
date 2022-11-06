package com.company;

import java.util.ArrayList;

public class Garaje {
    String id;
    ArrayList <Vehiculo> listado = new ArrayList<>();

    public Garaje() {
    }

    public Garaje(String id, ArrayList<Vehiculo> listado) {
        this.id = id;
        this.listado = listado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public ArrayList<Vehiculo> getListado() {
        return listado;
    }

    public void setLisado(Vehiculo vehiculo) {
        listado.add(vehiculo);
    }
}
