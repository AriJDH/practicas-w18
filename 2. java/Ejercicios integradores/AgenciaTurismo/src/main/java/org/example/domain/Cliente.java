package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int dni;
    private String nombreCompleto;
    private List<Localizador> localizadores = new ArrayList<>();

    public Cliente(int dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public int cantidadLocalizadores(){
        return this.localizadores.size();
    }

    public void addLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }
}
