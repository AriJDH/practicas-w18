package com.calorias.calorias.repository;

import com.calorias.calorias.entity.Ingrediente;
import com.calorias.calorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class RepositoryPlatos {

    private RepositoryIngredientes  repositoryIngredientes;
    private List<Plato> platoList = new ArrayList<>();


    public RepositoryPlatos() throws IOException {
        repositoryIngredientes = new RepositoryIngredientes();
        loadPlatos();
        System.out.println("Hola");
    }


    private void loadPlatos(){
        Random r = new Random();
        for (int i = 0;i<10;i++){
            List<Ingrediente> ingredientes = new ArrayList<>();
            int num_ingredientes = r.nextInt(10)+2;
            int cant_ing = repositoryIngredientes.getIngredienteList().size();
            for (int j = 0; j< num_ingredientes; j++){
                //cargamos los ingredientes en una lista
                ingredientes.add(repositoryIngredientes.getIngredienteList().get(r.nextInt(cant_ing-1)+1));
            }
            platoList.add(new Plato(i,"Plato " + i,ingredientes));

        }
    }


    public Plato getPlatoById(Integer idPlato){
        return platoList.stream()
                .filter(plato -> plato.getIdPlato() == idPlato)
                .findFirst()
                .get();
    }

}
