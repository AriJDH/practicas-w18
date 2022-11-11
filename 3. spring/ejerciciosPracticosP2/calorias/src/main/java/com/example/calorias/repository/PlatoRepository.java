package com.example.calorias.repository;

import com.example.calorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlatoRepository implements IPlatoRepository{

    public PlatoRepository() {
        this.cargarLista();
    }

    private List<Plato> listaPlatos = new ArrayList<>();

    @Override
    public List<Plato> findAll() {
        return listaPlatos;
    }

    @Override
    public void cargarLista() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            listaPlatos = mapper.readValue(jsonFile, new TypeReference<List<Plato>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
