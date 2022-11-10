package com.example.demo.repository;

import com.example.demo.entity.Deporte;
import com.example.demo.entity.Persona;
import com.example.demo.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonaCrud implements CrudRepository<Persona> {
    List<Persona> personaList = new ArrayList<>();

    @Override
    public void guardar(Persona objeto) {
        personaList.add(objeto);
    }

    @Override
    public List<Persona> buscar(String nombre) {
        List<Persona> personaBuscada = new ArrayList<>();
        personaBuscada = personaList.stream().filter(p->p.getNombre().equals(nombre)).collect(Collectors.toList());
        return personaBuscada;
    }

    @Override
    public List<Persona> listar() {
        return personaList;
    }

    public void loadData(){
        Persona pepe = new Persona("Pepe","Sierra", 37);
        Persona luis = new Persona("Luis","Narvaez", 20);
        Persona estella = new Persona("Estella","Rios", 18);
        Persona nico = new Persona("Nico","Benedetti", 40);
        this.guardar(pepe);
        this.guardar(luis);
        this.guardar(estella);
        this.guardar(nico);
    }
}
