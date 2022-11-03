package meli.bootcamp.clases;

import meli.bootcamp.repositories.RepositorioCliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cliente {
    private long id;
    private String nombre;
    private String apellido;
    private ArrayList<Localizador> localizadores;
    private RepositorioCliente rCliente;

    public Cliente(long id) {
        this.id = id;
        this.nombre = "a";
        this.apellido = "b";
        localizadores = new ArrayList<Localizador>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public boolean tieneDosLocalizadores(){
        return localizadores.size() >= 2;
    }

    public void agregarLocalizador(Localizador l)
    {
        localizadores.add(l);
    }
}
