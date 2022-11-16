package com.example.deportes.repositorio;

import com.example.deportes.entity.Deportes;

import java.util.ArrayList;
import java.util.List;


public class DeportesRepositorio {

    List<Deportes> deportes = new ArrayList<>();

    public void setDeportes(Deportes deporte) {
        deportes.add(deporte);
    }
    public void setDeportes() {cargarDatos();}

    public List<Deportes> getDeportes() {
        return deportes;
    }

    private void cargarDatos(){
        Deportes basquet = new Deportes(1,"Basquet", "Medio");
        Deportes waterpolo = new Deportes(2,"Waterpolo", "Dificil");
        Deportes volley = new Deportes(3,"Volley", "Medio");
        Deportes hockey = new Deportes(4,"Hockey", "Dificil");
        Deportes tenis = new Deportes(5,"Tenis", "Dificil");
        Deportes futbol = new Deportes(6,"Futbol", "Fácil");

        deportes.add(futbol);
        deportes.add(tenis);
        deportes.add(hockey);
        deportes.add(volley);
        deportes.add(waterpolo);
        deportes.add(basquet);
    }
}
