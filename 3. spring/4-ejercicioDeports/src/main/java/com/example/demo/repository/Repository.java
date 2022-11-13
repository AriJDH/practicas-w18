package com.example.demo.repository;

import com.example.demo.entity.Deporte;
import com.example.demo.entity.People;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    //Almacenamiento de valores a traves de listas

    List<People> listPeople = new ArrayList<>();
    List<Deporte> listDeports = new ArrayList<>();

    //inicialización de valores
    public Repository() {
        addListDeports();
        addListPeople();
    }

    //metodos de carga de valores
    public void addListPeople() {
        listPeople.add(new People("Juan", "Perez", 32, "Atletismo"));
        listPeople.add(new People("Juan", "Perez", 23, "Atletismo"));
        listPeople.add(new People("Carlos", "Restrepo", 26, "Futbol"));
        listPeople.add(new People("Carlos", "Martinez", 26, "Ciclismo"));
        listPeople.add(new People("Laura", "Perez", 24, "Atletismo"));
    }

    public void addListDeports() {
        listDeports.add(new Deporte("Atletismo", "Amateur"));
        listDeports.add(new Deporte("Futbol", "Amateur"));
        listDeports.add(new Deporte("Ciclismo", "Amateur"));
    }

    //metodo para retornar todo el listado de deportes
    public List<Deporte> findSports() {
        return listDeports;
    }

    //metodo para retornar todo el listado de personas
    public List<People> findPeople() {
        return listPeople;
    }

    //metodo para retornar un deporte por nombre
    public Deporte findSportByName(String name) {
        for (Deporte deporte : listDeports) {
            if (deporte.getName().equals(name)) {
                return deporte;
            }
        }
        return null;
    }


}
