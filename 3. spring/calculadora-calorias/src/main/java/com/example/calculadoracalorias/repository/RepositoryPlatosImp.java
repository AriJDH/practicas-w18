package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryPlatosImp implements IRepositoryPlatos{

    private List<Plato> platoList = new ArrayList<>();
    private List<Ingrediente> ingredienteList = new ArrayList<>();

    public RepositoryPlatosImp() {
        loadList();
    }


    @Override
    public void add(Plato plato) {
        platoList.add(plato);
    }

    @Override
    public List<Plato> listAll() {
        return platoList;
    }

    @Override
    public Plato findByName(String name) {
        return platoList.stream().filter(x-> x.getName().equals(name)).findFirst().orElse(null);
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredienteList = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }
}
