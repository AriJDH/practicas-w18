package com.mercadolibre.cuentacalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.cuentacalorias.entity.Ingrediente;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import javax.xml.stream.events.Characters;
import java.io.File;
import java.util.List;

@Repository
public class IngredienteRepository implements IIngredienteRepository{
    private List<Ingrediente> ingredientes;

    public IngredienteRepository() {
        this.loadList();
    }

    private void loadList(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile= null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (Exception ex){
            System.out.println("No existe el archivo. " + ex.getMessage());
        }
    }

    @Override
    public List<Ingrediente> getAll() {
        return this.ingredientes;
    }

    @Override
    public Ingrediente findByName(String name) {
        return this.ingredientes
                .stream()
                .filter(i->i.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("No existe el ingrediente"));
    }
}
