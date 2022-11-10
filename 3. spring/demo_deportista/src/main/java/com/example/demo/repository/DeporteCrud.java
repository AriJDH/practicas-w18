package com.example.demo.repository;

import com.example.demo.entity.Deporte;
import com.example.demo.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeporteCrud implements CrudRepository<Deporte> {

    private List<Deporte> deporteList = new ArrayList<Deporte>();

    @Override
    public void guardar(Deporte objeto) {
        deporteList.add(objeto);
    }

    @Override
    public List<Deporte> buscar(String nombre) {
        List<Deporte> deporteBuscado = new ArrayList<>();
        deporteBuscado = deporteList.stream().filter(d->d.getNombre().equals(nombre)).collect(Collectors.toList());
        return deporteBuscado;
    }

    @Override
    public List<Deporte> listar() {
        return deporteList;
    }

    public void loadData(){
        Deporte futbol = new Deporte("Futbol","Medio");
        Deporte basquetbol = new Deporte("Basquetbol","Medio");
        Deporte tennis = new Deporte("Tennis","Alto");
        Deporte futbolCinco = new Deporte("Futbol Cinco","Alto");
        this.guardar(futbol);
        this.guardar(basquetbol);
        this.guardar(tennis);
        this.guardar(futbolCinco);
    }
}
