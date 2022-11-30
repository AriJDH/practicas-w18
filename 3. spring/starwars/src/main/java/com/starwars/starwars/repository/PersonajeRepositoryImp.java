package com.starwars.starwars.repository;

import com.starwars.starwars.entity.Personaje;

import java.util.ArrayList;
import java.util.List;

public class PersonajeRepositoryImp implements PersonajeRepository{
    @Override
    public Personaje findPersonajeByName(String name) {
        return null;
    }




    private void loadData(){
        List<Personaje> personajes = new ArrayList<>(){{
            add(new Personaje("Yoda",66,13,"White","Green","Black","896 ABY","M","Secret","Rare"));
            add(new Personaje("Chewbacca",230,150,"Brown","Brown","Blue","200 ABY","M","Kashyyyk","Wookie"));
            add(new Personaje("Darth Vader",203,120,"Blond","Clear","Blue","41 ABY","M","Tatooine","Human"));
            add(new Personaje("Leia Organa",155,50,"Brown","Clear","Brown","19 ABY","F","Alderaan","Human"));
        }};
    }
}
