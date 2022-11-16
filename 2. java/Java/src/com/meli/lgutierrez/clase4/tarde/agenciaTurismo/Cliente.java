package com.meli.lgutierrez.clase4.tarde.agenciaTurismo;

import com.meli.lgutierrez.clase4.tarde.agenciaTurismo.repositorio.RepositorioCliente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private List<Localizador> localizadores;
    private RepositorioCliente rp;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
        this.rp = new RepositorioCliente();
    }

    public void guardarCliente(){
        rp.guardarCliente(this);
    }

    public void mostrarReservas(){
        rp.mostrarReservas(this);
    }

    public void agregarLocalizador(Localizador localizador){
        rp.agregarLocalizador(this, localizador);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", localizadores=" + localizadores +
                '}';
    }
}
