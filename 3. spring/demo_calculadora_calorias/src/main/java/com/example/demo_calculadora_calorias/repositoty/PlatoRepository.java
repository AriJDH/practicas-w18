package com.example.demo_calculadora_calorias.repositoty;

import com.example.demo_calculadora_calorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepository implements IPlatoRepository{

    List<Plato> platoList = new ArrayList<>();
    public PlatoRepository(){
        this.loadList();
    }

    @Override
    public List<Plato> findAll() {
        return platoList;
    }

    @Override
    public void loadList() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            platoList = mapper.readValue(jsonFile, new TypeReference<List<Plato>>() { });
        } catch (Exception e) {
            System.out.println("No existe el archivo "+e.getMessage());
        }
    }
}
